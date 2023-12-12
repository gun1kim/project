package com.example.practice.controller;

import com.example.practice.dto.mission.MissionDto;
import com.example.practice.service.MissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class MissionController {

    private final MissionService missionService;

//    @GetMapping("/missions")
//    public List<MissionDto> missionList() {
//        return missionService.findAll();
//    }

    @GetMapping("/missions")
    public Page<MissionDto> missionList(@PageableDefault(size = 8) Pageable pageable) {
        return missionService.findAllMissions(pageable);
    }

    @GetMapping("/missions/{missionId}")
    public MissionDto missionDetails(@PathVariable Long id) {
        return missionService.findById(id);
    }

    @GetMapping("/missions/status")
    public Page<MissionDto> missionListByStatus(@RequestParam("status") String status, @PageableDefault(size = 8) Pageable pageable) {
        return missionService.findByStatus(status, pageable);
    }

    @GetMapping("/missions/title")
    public Page<MissionDto> missionListByTitle(@RequestParam String title, @PageableDefault(size = 8) Pageable pageable) {
        return missionService.findAllByTitleLike(title, pageable);
    }

    @GetMapping("/missions/category")
    public Page<MissionDto> missionListByCategory(@RequestParam String category, @PageableDefault(size = 8) Pageable pageable) {
        return missionService.findByCategoryLike(category, pageable);
    }



//    @PostMapping("/missions/add")
//    public ResponseEntity<Resource> missionAdd(@ModelAttribute MissionCreateDto missionCreateDto) {
//        Mission mission = new Mission();
//        saveFile(missionCreateDto.getImage());
//    }

    @DeleteMapping("/missions/{missionId}")
    public void missionRemove(@PathVariable Long missionId) {

    }
}
