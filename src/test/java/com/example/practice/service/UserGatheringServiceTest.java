package com.example.practice.service;

import com.example.practice.domain.Gathering;
import com.example.practice.domain.User;
import com.example.practice.domain.UserGathering;
import com.example.practice.repository.GatheringRepository;
import com.example.practice.repository.UserGatheringRepository;
import com.example.practice.repository.UserRepository;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class UserGatheringServiceTest {

//    @Autowired
//    private final UserGatheringService userGatheringService;
//    @Autowired
//    private final UserService userService;
//    @Autowired
//    private final GatheringService gatheringService;

    @Autowired
    private UserGatheringService userGatheringService;

    @Autowired
    private  UserGatheringRepository userGatheringRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private GatheringRepository gatheringRepository;


//    public UserGatheringServiceTest(UserGatheringRepository userGatheringRepository, UserRepository userRepository, GatheringRepository gatheringRepository) {
//        this.userGatheringRepository = userGatheringRepository;
//        this.userRepository = userRepository;
//        this.gatheringRepository = gatheringRepository;
//    }

    @Test
    void join() throws Exception {
        User user = new User();
        user.setName("tester");
        user.setId("test");
        user.setPassword("1234");
        user.setEmail("test@test.com");
        user.setCreateAt(new Timestamp(System.currentTimeMillis()));
        userRepository.save(user);



        User user2 = new User();
        user2.setName("tester");
        user2.setId("test2");
        user2.setPassword("1234");
        user2.setEmail("test2@test.com");
        user2.setCreateAt(new Timestamp(System.currentTimeMillis()));
        userRepository.save(user2);

        Gathering gathering = new Gathering();
        gathering.setTitle("테스트모임1");
        gathering.setContent("모임테스트1번입니다");
        gathering.setCapacity(2);
        gathering.setCreateAt(new Timestamp(System.currentTimeMillis()));
        gatheringRepository.save(gathering);
        System.out.println("gathering.getCount() = " + gathering.getCount());

        Gathering gathering2 = new Gathering();
        gathering2.setTitle("테스트모임2");
        gathering2.setContent("모임테스트2번입니다");
        gathering2.setCapacity(1);
        gathering2.setCreateAt(new Timestamp(System.currentTimeMillis()));
        gatheringRepository.save(gathering2);


        UserGathering userGathering = userGatheringService.joinGathering(user.getUserId(), gathering.getGatheringId());
//        System.out.println("userGathering = " + userGathering);
//        System.out.println("userGatheringRepository.findAll() = " + userGatheringRepository.findAll());
        System.out.println("gathering.getCount() = " + gathering.getCount());

    }

}