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

    public List<Gathering> findAll() {
        return gatheringRepository.findAll();
    }

    public Gathering findGatheringById(Long id) {
        return gatheringRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("no such data"));
    }

    public List<Gathering> findAllByStatus(boolean status) {
        return gatheringRepository.findAllByStatusEquals(status);
    }

    public void createGathering(String title, String content, int capacity) {
        gatheringRepository.save(new Gathering(title, content, capacity));
    }

    public void updateGathering(String title, String content, int capacity) {

    }

    public void deleteById(Long id) {
        gatheringRepository.deleteById(id);
    }

//    public void joinGathering(Long id) {
//        Gathering gathering = gatheringRepository.findById(id).get();
//        if (gathering.getCount() < gathering.getCapacity()) {
//            gathering.setCount(gathering.getCount() + 1);
//        }
//        gatheringRepository.joinGathering(id);
//    }

}
