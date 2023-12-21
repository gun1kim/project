package com.example.practice.controller.gathering;

import com.example.practice.entity.*;
import com.example.practice.dto.gathering.GatheringCreateDto;
import com.example.practice.dto.gathering.GatheringDto;
import com.example.practice.dto.gathering.GatheringUpdateDto;
import com.example.practice.dto.member.MemberDto;
import com.example.practice.service.gathering.GatheringService;
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
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@Slf4j
public class GatheringController {

    @Value("C:/Users/kki/file/")
    private String fileDir;

    private final GatheringService gatheringService;

//    @GetMapping("/gathering")
//    public Page<GatheringDto> gatheringList(@PageableDefault(size = 8) Pageable pageable) {
//        Page<Gathering> page = gatheringService.findAllGatherings(pageable);
//        Page<GatheringDto> pageDto = page.map(GatheringDto::fromEntity);
//        return pageDto;
//
//    }

    @GetMapping("/gathering")
    public Page<GatheringDto> gatheringList(@RequestParam(required = false) String status, @RequestParam(required = false) String title,
                                            @PageableDefault(size = 8) Pageable pageable) {
        Page<Gathering> gatherings;
        if (status != null && title != null) {
            gatherings = gatheringService.findGatheringByStatusAndTitle(status, title, pageable);
        } else if (status != null) {
            gatherings = gatheringService.findGatheringByStatus(status, pageable);
        } else if (title != null) {
            gatherings = gatheringService.findGatheringByTitle(title, pageable);
        } else {
            gatherings = gatheringService.findAllGatherings(pageable);
        }
        Page<GatheringDto> gatheringDtos = gatherings.map(GatheringDto::fromEntity);
        return gatheringDtos;
    }

    @GetMapping("/gathering/{gatheringId}")
    public ResponseEntity<GatheringDto> gatheringDetails(@PathVariable Long gatheringId) {
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

    @GetMapping("/gathering/statusAndTitle")
    public Page<GatheringDto> gatheringListsByStatusAndTitle(@RequestParam(required = false) String status, @RequestParam(required = false) String title,
                                                             @PageableDefault(size = 8) Pageable pageable) {
        Page<Gathering> gatherings = gatheringService.findGatheringByStatusAndTitle(status, title, pageable);
        Page<GatheringDto> gatheringDtos = gatherings.map(GatheringDto::fromEntity);
        return gatheringDtos;
    }




    @PostMapping("/gathering")
    public ResponseEntity<Resource> gatheringAdd(@ModelAttribute GatheringCreateDto gatheringCreateDto) throws IOException {
        log.info("id = {}", gatheringCreateDto.getCreatorId());
        Gathering gathering = new Gathering();
        String imageName = saveFile(gatheringCreateDto.getImage());
        gathering.setImage(imageName);

        gatheringService.addGathering(gatheringCreateDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/gathering/{gatheringId}")
    public void gatheringModify(@PathVariable Long gatheringId, @ModelAttribute GatheringUpdateDto gatheringUpdateDto) throws IOException {
        Gathering gathering = gatheringService.findGatheringById(gatheringId);;
        String imageName = saveFile(gatheringUpdateDto.getImage());
        gathering.setImage(imageName);
        gatheringService.modifyGathering(gatheringId, gatheringUpdateDto);
    }

    @GetMapping("/gathering/{gatheringId}/members")
    public List<MemberDto> gatheringMembers(@PathVariable Long gatheringId) {
        Gathering gathering = gatheringService.findGatheringById(gatheringId);
        List<MemberGathering> memberGatherings = gathering.getMemberGatherings();

        List<MemberDto> members = memberGatherings.stream()
                .map(memberGathering -> MemberDto.fromEntity(memberGathering.getMember()))
                .collect(Collectors.toList());
        log.info("members = {}", members);
        return members;
    }

    @DeleteMapping("/gathering/{gatheringId}")
    public void gatheringRemove(@PathVariable Long gatheringId) {

        gatheringService.removeById(gatheringId);

    }

//    @GetMapping("/gathering/{gatheringId}/members")
//    public List<MemberDto> getGatheringMembers(@PathVariable Long gatheringId) {
//        List<Member> gatheringMembers = gatheringService.getGatheringMembers(gatheringId);
//        List<MemberDto> memberDtos = gatheringMembers.stream()
//                .map(MemberDto::fromEntity)
//                .collect(Collectors.toList());
//        return memberDtos;
//    }


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
