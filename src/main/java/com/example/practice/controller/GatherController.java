package com.example.practice.controller;

import com.example.practice.domain.Gathering;
import com.example.practice.domain.User;
import com.example.practice.domain.UserGathering;
import com.example.practice.dto.GatheringCreateDto;
import com.example.practice.dto.GatheringDto;
import com.example.practice.dto.GatheringUpdateDto;
import com.example.practice.service.GatheringService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
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


//    @GetMapping("/gathering")
//    public List<Gathering> getAllGatherings() {
//        return gatheringService.getAllGatherings();
//    }

    @GetMapping("/gathering")
    public ResponseEntity<List<GatheringDto>> findAll() {
        List<Gathering> gatherings = gatheringService.getAllGatherings();
        List<GatheringDto> gatheringDtos = gatherings.stream()
                .map(GatheringDto::fromEntity)
                .collect(Collectors.toList());
        return new ResponseEntity<>(gatheringDtos, HttpStatus.OK);
    }

//    @GetMapping("/gathering/{gatheringId}")
//    public ResponseEntity<Gathering> getGatheringById(@PathVariable Long gatheringId) {
//        Gathering gathering = gatheringService.getGatheringById(gatheringId);
//
//        if (gathering == null) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//
//        return new ResponseEntity<>(gathering, HttpStatus.OK);
//    }

    @GetMapping("/gathering/{gatheringId}")
    public ResponseEntity<GatheringDto> getGatheringById(@PathVariable Long gatheringId) {
        Gathering gathering = gatheringService.getGatheringById(gatheringId);
        GatheringDto gatheringDto = GatheringDto.fromEntity(gathering);
        return new ResponseEntity<>(gatheringDto, HttpStatus.OK);
    }

    @GetMapping("/gathering/status?{status}")
    public List<Gathering> getGatheringByStatus(@PathVariable boolean status) {
        List<Gathering> gatherings = gatheringService.getAllByStatus(status);
//        List<Gathering> list = new ArrayList<>();
//        for (Gathering gathering : gatherings) {
//            if (gathering.isStatus() == status) {
//                list.add(gathering);
//            }
//        }
        return gatherings;
    }



    @PostMapping("/gathering")
    public ResponseEntity<Resource> addGathering(@ModelAttribute GatheringCreateDto gatheringCreateDto) throws IOException {
        Gathering gathering = new Gathering();
        String imageName = saveFile(gatheringCreateDto.getImage());
        gathering.setImage(imageName);
        Long creatorId = 1L;

        gatheringService.createGathering(gatheringCreateDto, creatorId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

//    @PostMapping("/gathering")
//    public ResponseEntity<Resource> addGathering(@ModelAttribute GatheringCreateDto gatheringCreateDto, @RequestParam Long creatorId) throws IOException {
//        Gathering gathering = new Gathering();
//        String imageName = saveFile(gatheringCreateDto.getImage());
//        gathering.setImage(imageName);
//
//        gatheringService.createGathering(gatheringCreateDto, creatorId);
//        return ResponseEntity.status(HttpStatus.OK).build();
//    }


    @PutMapping("/gathering/{gatheringId}")
    public void updateGathering(@PathVariable Long gatheringId, @ModelAttribute GatheringUpdateDto gatheringUpdateDto) throws IOException {
        String imageName = saveFile(gatheringUpdateDto.getImage());
        gatheringService.updateGathering(gatheringId, gatheringUpdateDto);
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
