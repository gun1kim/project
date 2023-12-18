package com.example.practice.controller;

import com.example.practice.dto.member.MemberGatheringDto;
import com.example.practice.entity.Gathering;
import com.example.practice.entity.MemberGathering;
import com.example.practice.entity.Status;
import com.example.practice.entity.Member;
import com.example.practice.jwt.CustomMemberDetails;
import com.example.practice.service.GatheringService;
import com.example.practice.service.MemberGatheringService;
import com.example.practice.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class MemberGatheringController {

    private final MemberService memberService;
    private final GatheringService gatheringService;
    private final MemberGatheringService memberGatheringService;
//
//    @GetMapping("/membergatherings/members/{memberId}/gathering/{gatheringId}")
//    public void joinGathering(@PathVariable Long memberId, @PathVariable Long gatheringId) throws Exception {
//        Member member = memberService.getMemberById(memberId);
//        Gathering gathering = gatheringService.findGatheringById(gatheringId);
//
//        if (gathering.getStatus() != Status.OPEN) {
//            throw new Exception("모임이 모집 중이 아닙니다.");
//        }
//
//        memberGatheringService.joinGathering(member.getMemberId(), gathering.getGatheringId());
//
//    }

    @GetMapping("/members/{memberId}/gathering/{gatheringId}/join")
    public void joinGathering(@AuthenticationPrincipal CustomMemberDetails memberDetails, @PathVariable Long gatheringId) throws Exception {
        log.info("memberDetails = {}", memberDetails.getMemberId());
        Member member = memberService.getMemberById(memberDetails.getMemberId());
        Gathering gathering = gatheringService.findGatheringById(gatheringId);

        if (gathering.getStatus() != Status.OPEN) {
            throw new Exception("모임이 모집 중이 아닙니다.");
        }

        memberGatheringService.joinGathering(member.getMemberId(), gathering.getGatheringId());

    }



    @GetMapping("/membergatherings/gathering/{gatheringId}/members")
    public List<MemberGatheringDto> joinGatheringMembers(@PathVariable Long gatheringId) {
        Gathering gathering = gatheringService.findGatheringById(gatheringId);
        List<MemberGathering> memberGatherings = gathering.getMemberGatherings();
        List<MemberGatheringDto> dtos = memberGatherings.stream().map(MemberGatheringDto::fromEntity).collect(Collectors.toList());
        return dtos;
    }
}

