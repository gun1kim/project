package com.example.practice.controller;


import com.example.practice.dto.MemberMissionPostDto;
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

    private final MemberService memberService;
    private final MissionService missionService;
    private final MemberMissionService memberMissionService;

    @PostMapping("/members/{memberId}/missions/{missionId}")
    public ResponseEntity<?> joinMission(@PathVariable Long missionId, @AuthenticationPrincipal CustomMemberDetails memberDetails) {
        memberMissionService.joinMission(memberDetails.getMemberId(),missionId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/members/missions/posts")
    public ResponseEntity<?> writeMissionPost(@RequestBody MemberMissionPostDto memberMissionPostDto) {
        memberMissionService.addMemberMissionPost(memberMissionPostDto);

        return ResponseEntity.ok(HttpStatus.CREATED);
    }


}
