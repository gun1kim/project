package com.example.practice.service;

import com.example.practice.domain.Gathering;
import com.example.practice.domain.User;
import com.example.practice.domain.UserGathering;
import com.example.practice.dto.GatheringCreateDto;
import com.example.practice.dto.GatheringDto;
import com.example.practice.dto.GatheringUpdateDto;
import com.example.practice.image.FileStore;
import com.example.practice.repository.GatheringRepository;
import com.example.practice.repository.UserGatheringRepository;
import com.example.practice.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
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

    public List<Gathering> getAllGatherings() {
        return gatheringRepository.findAll();
    }

    public Page<Gathering> getAllGatherings(Pageable pageable) {
        return gatheringRepository.findAll(pageable);
    }
    public Gathering getGatheringById(Long gatheringId) {

        return gatheringRepository.findById(gatheringId).orElseThrow(() -> new IllegalArgumentException("no such data"));

    }

    public Page<Gathering> getAllByStatus(boolean status, Pageable pageable) {
        return gatheringRepository.findAllByStatusEquals(status, pageable);

    }

    public Page<Gathering> getAllByTitle(String title, Pageable pageable) {
        return gatheringRepository.findByTitleLike("%" + title + "%", pageable);
    }


    public void createGathering(GatheringCreateDto gatheringCreateDto) {
        Gathering gathering = new Gathering();
        gathering.setTitle(gatheringCreateDto.getTitle());
        gathering.setIntro(gatheringCreateDto.getIntro());
        gathering.setEtc(gatheringCreateDto.getEtc());
        gathering.setLocation(gatheringCreateDto.getLocation());
        gathering.setImage(gatheringCreateDto.getImage().getOriginalFilename());
        gathering.setCapacity(gatheringCreateDto.getCapacity());
        
        gatheringRepository.save(gathering);
    }


    public void createGathering(GatheringCreateDto gatheringCreateDto, Long creatorId) {  // Add creatorId parameter
        User creator = userRepository.findById(creatorId)  // Load the user from the database
                .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + creatorId));

//        Gathering gathering = gatheringCreateDto.toEntity(creator);
//        gatheringRepository.save(gathering);

        Gathering gathering = new Gathering();
        gathering.setTitle(gatheringCreateDto.getTitle());
        gathering.setIntro(gatheringCreateDto.getIntro());
        gathering.setEtc(gatheringCreateDto.getEtc());
        gathering.setLocation(gatheringCreateDto.getLocation());
        gathering.setImage(gatheringCreateDto.getImage().getOriginalFilename());
        gathering.setCapacity(gatheringCreateDto.getCapacity());
        gathering.setCreator(creator);  // Set the creator of the gathering
        creator.getCreateGatherings().add(gathering); // Add the gathering to the user's createdGatherings list

        gatheringRepository.save(gathering);

    }

    public void updateGathering(Long gatheringId, GatheringUpdateDto gatheringUpdateDto) {
        Gathering gathering = gatheringRepository.findById(gatheringId).orElseThrow(() -> new IllegalArgumentException("no such gathering"));

//        User creator = userRepository.findById(gatheringUpdateDto.getCreatorId()).orElseThrow(() -> new IllegalArgumentException("user not found"));

        gatheringUpdateDto.updateGathering(gathering);


//        gatheringRepository.save(gathering);
    }

    public void deleteById(Long id) {
//        gatheringRepository.deleteById(id);
        Gathering gathering = gatheringRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Gathering not found with id: " + id));

        List<UserGathering> userGatherings = gathering.getUserGatherings();
        for (UserGathering userGathering : userGatherings) {
            userGatheringRepository.delete(userGathering);
        }
//        gathering.getUserGatherings().clear();

        gatheringRepository.deleteById(id);
    }

}
