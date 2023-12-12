package com.example.practice.controller;

import com.example.practice.entity.Gathering;
import com.example.practice.entity.Status;
import com.example.practice.entity.Member;
import com.example.practice.service.GatheringService;
import com.example.practice.service.MemberGatheringService;
import com.example.practice.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MemberGatheringController {

    private final MemberService memberService;
    private final GatheringService gatheringService;
    private final MemberGatheringService memberGatheringService;

    @GetMapping("/membergatherings/members/{memberId}/gathering/{gatheringId}")
    public void joinGathering(@PathVariable Long memberId, @PathVariable Long gatheringId) throws Exception {
        Member member = memberService.getMemberById(memberId);
        Gathering gathering = gatheringService.findGatheringById(gatheringId);

        if (gathering.getStatus() != Status.OPEN) {
            throw new Exception("모임이 모집 중이 아닙니다.");
        }

        memberGatheringService.joinGathering(member.getMemberId(), gathering.getGatheringId());


    }
}

