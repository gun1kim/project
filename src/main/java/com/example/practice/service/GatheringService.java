package com.example.practice.service;

import com.example.practice.domain.Gathering;
import com.example.practice.domain.Status;
import com.example.practice.domain.User;
import com.example.practice.domain.UserGathering;
import com.example.practice.dto.GatheringCreateDto;
import com.example.practice.dto.GatheringDto;
import com.example.practice.dto.GatheringUpdateDto;
import com.example.practice.image.FileStore;
import com.example.practice.repository.GatheringRepository;
import com.example.practice.repository.UserGatheringRepository;
import com.example.practice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class GatheringService {



    private final GatheringRepository gatheringRepository;
    private final UserRepository userRepository;
    private final UserGatheringRepository userGatheringRepository;

    @Transactional(readOnly = true)
    public List<Gathering> getAllGatherings() {
        return gatheringRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Page<Gathering> findAllGatherings(Pageable pageable) {
        return gatheringRepository.findAll(pageable);
    }
    @Transactional(readOnly = true)
    public Gathering findGatheringById(Long gatheringId) {

        return gatheringRepository.findById(gatheringId).orElseThrow(() -> new IllegalArgumentException("no such data"));

    }
    @Transactional(readOnly = true)
    public Page<Gathering> findGatheringByStatus(String status, Pageable pageable) {
        Status statusEnum = Status.valueOf(status);
        return gatheringRepository.findAllByStatusEquals(statusEnum, pageable);
    }

    @Transactional(readOnly = true)
    public Page<Gathering> findGatheringByTitle(String title, Pageable pageable) {
        return gatheringRepository.findByTitleLike("%" + title + "%", pageable);
    }



    public void addGathering(GatheringCreateDto gatheringCreateDto, Long creatorId) {  // Add creatorId parameter
        User creator = userRepository.findById(creatorId)  // Load the user from the database
                .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + creatorId));

        Gathering gathering = new Gathering();
        gathering.setTitle(gatheringCreateDto.getTitle());
        gathering.setIntro(gatheringCreateDto.getIntro());
        gathering.setEtc(gatheringCreateDto.getEtc());
        gathering.setLocation(gatheringCreateDto.getLocation());
        gathering.setImage(gatheringCreateDto.getImage().getOriginalFilename());
        gathering.setCapacity(gatheringCreateDto.getCapacity());

        if (gatheringCreateDto.getDeadline().isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("모집 마감일은 오늘 날짜보다 작은 값으로는 설정 할 수 없습니다.");
        }
        if (gatheringCreateDto.getStartAt().isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("모임 시작일은 오늘 날짜보다 작은 값으로는 설정 할 수 없습니다.");
        }

        gathering.setDeadline(gatheringCreateDto.getDeadline());
        gathering.setStartAt(gatheringCreateDto.getStartAt());

        gathering.setCreator(creator);  // Set the creator of the gathering
        creator.getCreateGatherings().add(gathering); // Add the gathering to the user's createdGatherings list

        gatheringRepository.save(gathering);

    }

    public void modifyGathering(Long gatheringId, GatheringUpdateDto gatheringUpdateDto) {
        Gathering gathering = gatheringRepository.findById(gatheringId).orElseThrow(() -> new IllegalArgumentException("no such gathering"));

        if (gatheringUpdateDto.getDeadline().isBefore(LocalDateTime.now())) {
            new IllegalArgumentException("모집 마감일은 오늘 날짜보다 작은 값으로는 설정 할 수 없습니다.");
        }
        if (gatheringUpdateDto.getStartAt().isBefore(LocalDateTime.now())) {
            new IllegalArgumentException("모임 시작일은 오늘 날짜보다 작은 값으로는 설정 할 수 없습니다.");
        }

        gatheringUpdateDto.updateGathering(gathering);

    }

    public void removeById(Long id) {
        Gathering gathering = gatheringRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Gathering not found with id: " + id));

        List<UserGathering> userGatherings = gathering.getUserGatherings();
        for (UserGathering userGathering : userGatherings) {
            userGatheringRepository.delete(userGathering);
        }
        gatheringRepository.deleteById(id);
    }

    @Scheduled(cron = "0 0 0 * * *")
    public void modifyGatheringStatus() {
        List<Gathering> gatherings = gatheringRepository.findAll();
        for (Gathering gathering : gatherings) {
            if (gathering.getDeadline().isBefore(LocalDateTime.now())) {
                gathering.setStatus(Status.CLOSED);
            }
            if (gathering.getStartAt().isBefore(LocalDateTime.now())) {
                gathering.setStatus(Status.FINISHED);
            }
        }
    }


}
