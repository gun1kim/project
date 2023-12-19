package com.example.practice.controller;


import com.example.practice.dto.MemberMissionPostDto;
import com.example.practice.dto.MemberMissionRequestDto;
import com.example.practice.jwt.CustomMemberDetails;
import com.example.practice.service.MemberMissionService;
import com.example.practice.service.MemberService;
import com.example.practice.service.MissionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@Slf4j
@RequiredArgsConstructor
public class MemberMissionController {

    private final MemberMissionService memberMissionService;

    @PostMapping("/missions/{missionId}/join")
    public ResponseEntity<?> joinMission(@PathVariable Long missionId, @AuthenticationPrincipal CustomMemberDetails memberDetails) {
        memberMissionService.joinMission(memberDetails.getMemberId(),missionId);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }



    @PostMapping("/missions/{missionId}/post")
    public ResponseEntity<?> writeMissionPost(@ModelAttribute MemberMissionPostDto memberMissionPostDto) {
        memberMissionService.addMemberMissionPost(memberMissionPostDto);

        return ResponseEntity.ok(HttpStatus.CREATED);
    }


    // 관리자 컨트롤러로 나중에 뺴야할듯 ?
    @PutMapping("/missions/{missionId}/approval")
    public ResponseEntity<?> approveMissionPost(@RequestBody MemberMissionRequestDto memberMissionRequestDto) {
        log.info("memberMissionId = {}", memberMissionRequestDto);
        memberMissionService.approveMissionPost(memberMissionRequestDto.getMemberMissionId());

        return ResponseEntity.ok().build();
    }


}
