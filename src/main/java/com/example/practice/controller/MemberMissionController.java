package com.example.practice.controller;


import com.example.practice.jwt.CustomMemberDetails;
import com.example.practice.service.MemberMissionService;
import com.example.practice.service.MemberService;
import com.example.practice.service.MissionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Slf4j
@RequiredArgsConstructor
public class MemberMissionController {

    private final MemberService memberService;
    private final MissionService missionService;
    private final MemberMissionService memberMissionService;

    @PostMapping("/members/{memberId}/missions/{missionId}")
    public ResponseEntity<Void> joinMission(@PathVariable Long missionId, @AuthenticationPrincipal CustomMemberDetails memberDetails) {
        memberMissionService.joinMission(memberDetails.getMemberId(),missionId);
        return ResponseEntity.ok().build();
    }
}
