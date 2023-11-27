package com.example.practice.service;

import com.example.practice.domain.Gathering;
import com.example.practice.repository.GatheringRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GatheringService {

    private final GatheringRepository gatheringRepository;

    public List<Gathering> getAllGatherings() {
        return gatheringRepository.findAll();
    }

    public Gathering getGatheringById(Long id) {
        return gatheringRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("no such data"));
    }

    public List<Gathering> getAllByStatus(boolean status) {
        return gatheringRepository.findAllByStatusEquals(status);
    }

//    public void createGathering(String title, String content, int capacity) {
//        gatheringRepository.save(new Gathering(title, content, capacity));
//    }
    public void createGathering(Gathering gathering) {
        gatheringRepository.save(gathering);
    }

    public void updateGathering(Long id, String title, String content, int capacity) {
        Gathering gathering = gatheringRepository.findById(id).get();
        gathering.setTitle(title);
        gathering.setContent(content);
        gathering.setCapacity(capacity);
        gatheringRepository.save(gathering);
    }

    public void deleteById(Long id) {
        gatheringRepository.deleteById(id);
    }


}
