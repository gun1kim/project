package com.example.practice.controller;

import com.example.practice.domain.Gathering;
import com.example.practice.service.GatheringService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
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
}
