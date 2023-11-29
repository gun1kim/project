package com.example.practice.service;

import com.example.practice.domain.Gathering;
import com.example.practice.domain.User;
import com.example.practice.domain.UserGathering;
import com.example.practice.repository.GatheringRepository;
import com.example.practice.repository.UserGatheringRepository;
import com.example.practice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserGatheringService {

    private final UserGatheringRepository userGatheringRepository;
    private final UserRepository userRepository;
    private final GatheringRepository gatheringRepository;


    public UserGathering joinGathering(Long userId, Long gatheringId) throws Exception {
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("no such user"));
        Gathering gathering = gatheringRepository.findById(gatheringId).orElseThrow(() -> new IllegalArgumentException("no such gathering"));

        if (gathering.getCount() + 1 > gathering.getCapacity()) {
            log.info("모임 정원 초과");
            throw new Exception("모임 정원 초과");
        }
        else if (gathering.isStatus() == true) {
            log.info("마감된 모임입니다.");
            throw new Exception("마감된 모임");
        }
        gathering.setCount(gathering.getCount() + 1);
        gatheringRepository.save(gathering);
        UserGathering userGathering = new UserGathering();
        userGathering.setUser(user);
        userGathering.setGathering(gathering);
        return userGatheringRepository.save(userGathering);

    }

}
