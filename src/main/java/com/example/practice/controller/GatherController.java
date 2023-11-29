package com.example.practice.controller;

import com.example.practice.domain.Gathering;
import com.example.practice.domain.User;
import com.example.practice.domain.UserGathering;
import com.example.practice.service.GatheringService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@Slf4j
public class GatherController {

    private final GatheringService gatheringService;


    @GetMapping("/gathering")
    public List<Gathering> getAllGatherings() {
        return gatheringService.getAllGatherings();
    }

    @GetMapping("/gathering/{gatheringId}")
    public Gathering getGatheringById(@PathVariable Long gatheringId) {
        return gatheringService.getGatheringById(gatheringId);
    }

    @GetMapping("/gathering/status?{status}")
    public List<Gathering> getGatheringByStatus(@PathVariable boolean status) {
        List<Gathering> gatherings = gatheringService.getAllGatherings();
        List<Gathering> list = new ArrayList<>();
        for (Gathering gathering : gatherings) {
            if (gathering.isStatus() == status) {
                list.add(gathering);
            }
        }
        return list;
    }

    @PostMapping("/gathering")
    public void addGathering(@RequestBody Gathering gathering) {
        gatheringService.createGathering(gathering);

    }

    @GetMapping("/gathering/{gatheringId}/users")
    public List<User> getGatheringUsers(@PathVariable Long gatheringId) {
        Gathering gathering = gatheringService.getGatheringById(gatheringId);
        List<UserGathering> userGatherings = gathering.getUserGatherings();

        List<User> users = userGatherings.stream()
                .map(UserGathering::getUser)
                .collect(Collectors.toList());
        log.info("users = {}", users);
        return users;
    }

    @DeleteMapping("/gathering/{gatheringId}")
    public void removeGathering(@PathVariable Long gatheringId) {
        gatheringService.deleteById(gatheringId);
    }
}
