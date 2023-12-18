package com.example.practice.service;

import com.example.practice.entity.*;
import com.example.practice.dto.gathering.GatheringCreateDto;
import com.example.practice.dto.gathering.GatheringUpdateDto;
import com.example.practice.repository.GatheringRepository;
import com.example.practice.repository.MemberGatheringRepository;
import com.example.practice.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class GatheringService {



    private final GatheringRepository gatheringRepository;
    private final MemberRepository memberRepository;
    private final MemberGatheringRepository memberGatheringRepository;
    private final S3FileUploader s3FileUploader;

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

    @Transactional(readOnly = true)
    public Page<Gathering> findGatheringByStatusAndTitle(String status, String title, Pageable pageable) {
        log.info("findGatheringByStatusAndTitle called");
        Status statusEnum = Status.valueOf(status);
        return gatheringRepository.findByStatusEqualsAndTitleLike(statusEnum, "%" + title + "%", pageable);
    }

    public void addGathering(GatheringCreateDto gatheringCreateDto) {
        Member creator = memberRepository.findById(gatheringCreateDto.getCreatorId()).orElseThrow(() -> new IllegalArgumentException("user not found with id: " + gatheringCreateDto.getCreatorId()));

        String filepath = "images/gathering";
        String imageUrl = s3FileUploader.uploadFileToS3(gatheringCreateDto.getImage(), filepath);

        Address address = new Address(gatheringCreateDto.getZoneCode(), gatheringCreateDto.getFullAddress(), gatheringCreateDto.getSubAddress());
        Gathering gathering = gatheringCreateDto.toEntity(creator);
        gathering.setLocation(address);
        gathering.setImage(imageUrl);
//        Gathering gathering = new Gathering();

//        gathering.setTitle(gatheringCreateDto.getTitle());
//        gathering.setIntro(gatheringCreateDto.getIntro());
//        gathering.setEtc(gatheringCreateDto.getEtc());
//        gathering.setLocation(address);
//        gathering.setImage(imageUrl);
//        gathering.setCapacity(gatheringCreateDto.getCapacity());

        if (gatheringCreateDto.getDeadline().isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("모집 마감일은 오늘 날짜보다 작은 값으로는 설정 할 수 없습니다.");
        }
        if (gatheringCreateDto.getStartAt().isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("모임 시작일은 오늘 날짜보다 작은 값으로는 설정 할 수 없습니다.");
        }

//        gathering.setDeadline(gatheringCreateDto.getDeadline());
//        gathering.setStartAt(gatheringCreateDto.getStartAt());
//
//        gathering.setCreator(creator);  // Set the creator of the gathering
        creator.getCreateGatherings().add(gathering); // Add the gathering to the user's createdGatherings list

        gatheringRepository.save(gathering);
    }

    public void addGathering(GatheringCreateDto gatheringCreateDto, Long creatorId) {  // Add creatorId parameter
        Member creator = memberRepository.findById(creatorId)  // Load the user from the database
                .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + creatorId));

        String filepath = "images/gathering";
        String imageUrl = s3FileUploader.uploadFileToS3(gatheringCreateDto.getImage(), filepath);
        Address address = new Address(gatheringCreateDto.getZoneCode(), gatheringCreateDto.getFullAddress(), gatheringCreateDto.getSubAddress());
        Gathering gathering = new Gathering();

        gathering.setTitle(gatheringCreateDto.getTitle());
        gathering.setIntro(gatheringCreateDto.getIntro());
        gathering.setEtc(gatheringCreateDto.getEtc());
        gathering.setLocation(address);
        gathering.setImage(imageUrl);
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
        String filePath = "images/gathering";
        String imageUrl = s3FileUploader.uploadFileToS3(gatheringUpdateDto.getImage(), filePath);
        gathering.setImage(imageUrl);
        if (gatheringUpdateDto.getDeadline().isBefore(LocalDateTime.now())) {
            new IllegalArgumentException("모집 마감일은 오늘 날짜보다 작은 값으로는 설정 할 수 없습니다.");
        }
        if (gatheringUpdateDto.getStartAt().isBefore(LocalDateTime.now())) {
            new IllegalArgumentException("모임 시작일은 오늘 날짜보다 작은 값으로는 설정 할 수 없습니다.");
        }

        gatheringUpdateDto.updateGathering(gathering);

    }

    public void removeById(Long gatheringId) {
        Gathering gathering = gatheringRepository.findById(gatheringId).orElseThrow(() -> new IllegalArgumentException("Gathering not found with id: " + gatheringId));

        List<MemberGathering> memberGatherings = gathering.getMemberGatherings();
        for (MemberGathering memberGathering : memberGatherings) {
            memberGatheringRepository.delete(memberGathering);
        }
        gatheringRepository.deleteById(gatheringId);
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
