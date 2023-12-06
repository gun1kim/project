package com.example.practice.controller;

import com.example.practice.domain.Gathering;
import com.example.practice.domain.Status;
import com.example.practice.domain.User;
import com.example.practice.domain.UserGathering;
import com.example.practice.dto.GatheringCreateDto;
import com.example.practice.dto.GatheringDto;
import com.example.practice.dto.GatheringUpdateDto;
import com.example.practice.dto.UserDto;
import com.example.practice.service.GatheringService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@Slf4j
public class GatherController {

    @Value("C:/Users/kki/file/")
    private String fileDir;

    private final GatheringService gatheringService;

    @GetMapping("/gathering")
    public Page<GatheringDto> gatheringList(@PageableDefault(size = 8) Pageable pageable) {
        Page<Gathering> page = gatheringService.findAllGatherings(pageable);
        Page<GatheringDto> pageDto = page.map(GatheringDto::fromEntity);
        return pageDto;

    }

    @GetMapping("/gathering/{gatheringId}")
    public ResponseEntity<GatheringDto> gatheringDetail(@PathVariable Long gatheringId) {
        Gathering gathering = gatheringService.findGatheringById(gatheringId);
        GatheringDto gatheringDto = GatheringDto.fromEntity(gathering);
        return new ResponseEntity<>(gatheringDto, HttpStatus.OK);
    }

    @GetMapping("/gathering/status")
    public Page<GatheringDto> gatheringListByStatus(@RequestParam String status, @PageableDefault(size = 8) Pageable pageable) {
        Page<Gathering> gatherings = gatheringService.findGatheringByStatus(status, pageable);
        Page<GatheringDto> gatheringDtos = gatherings.map(GatheringDto::fromEntity);
        return gatheringDtos;

    }

    @GetMapping("/gathering/title")
    public Page<GatheringDto> gatheringListByTitle(@RequestParam String title, @PageableDefault(size = 8) Pageable pageable) {
        Page<Gathering> gatherings = gatheringService.findGatheringByTitle(title, pageable);
        Page<GatheringDto> gatheringDtos = gatherings.map(GatheringDto::fromEntity);
        return gatheringDtos;
    }



    @PostMapping("/gathering")
    public ResponseEntity<Resource> gatheringAdd(@ModelAttribute GatheringCreateDto gatheringCreateDto) throws IOException {
        Gathering gathering = new Gathering();
        String imageName = saveFile(gatheringCreateDto.getImage());
        gathering.setImage(imageName);
        Long creatorId = 1L;

        gatheringService.addGathering(gatheringCreateDto, creatorId);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/gathering/{gatheringId}")
    public void gatheringModify(@PathVariable Long gatheringId, @ModelAttribute GatheringUpdateDto gatheringUpdateDto) throws IOException {
        String imageName = saveFile(gatheringUpdateDto.getImage());
        gatheringService.modifyGathering(gatheringId, gatheringUpdateDto);
    }

    @GetMapping("/gathering/{gatheringId}/users")
    public List<UserDto> gatheringUserList(@PathVariable Long gatheringId) {
        Gathering gathering = gatheringService.findGatheringById(gatheringId);
        List<UserGathering> userGatherings = gathering.getUserGatherings();

        List<UserDto> users = userGatherings.stream()
                .map(userGathering -> UserDto.fromEntity(userGathering.getUser()))
                .collect(Collectors.toList());
        log.info("users = {}", users);
        return users;
    }

    @DeleteMapping("/gathering/{gatheringId}")
    public void gatheringRemove(@PathVariable Long gatheringId) {

        gatheringService.removeById(gatheringId);


    }


    public String getFullPath(String filename) {
        return fileDir + filename;
    }

    public String saveFile(MultipartFile file) throws IOException {
        String fullPath = getFullPath(file.getOriginalFilename());
        File outputFile = new File(fullPath);
        if (!outputFile.getParentFile().exists()) {
            outputFile.getParentFile().mkdirs();
        }
        FileOutputStream fos = new FileOutputStream(outputFile);
        fos.write(file.getBytes());
        fos.close();
        return file.getOriginalFilename();

    }
}
