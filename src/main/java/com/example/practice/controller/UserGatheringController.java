package com.example.practice.controller;

import com.example.practice.domain.Gathering;
import com.example.practice.domain.Status;
import com.example.practice.domain.User;
import com.example.practice.service.GatheringService;
import com.example.practice.service.UserGatheringService;
import com.example.practice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserGatheringController {

    private final UserService userService;
    private final GatheringService gatheringService;
    private final UserGatheringService userGatheringService;

    @GetMapping("/usergatherings/users/{userId}/gathering/{gatheringId}")
    public void joinGathering(@PathVariable Long userId, @PathVariable Long gatheringId) throws Exception {
        User user = userService.getUserById(userId);
        Gathering gathering = gatheringService.findGatheringById(gatheringId);

        if (gathering.getStatus() != Status.OPEN) {
            throw new Exception("모임이 모집 중이 아닙니다.");
        }

        userGatheringService.joinGathering(user.getUserId(), gathering.getGatheringId());


    }
}

