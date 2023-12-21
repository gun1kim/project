package com.example.practice.controller.member;

import com.example.practice.dto.MemberMissionDto;
import com.example.practice.dto.point.PointDto;
import com.example.practice.dto.gathering.GatheringDto;
import com.example.practice.dto.member.MemberDto;
import com.example.practice.entity.*;
import com.example.practice.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
@Slf4j
public class MemberController {

    private final MemberService memberService;

    @GetMapping("")
    public List<Member> getAllMembers() {
        List<Member> list = memberService.findAllMember();
        return list;
    }

    @GetMapping("/{memberId}")
    public MemberDto getMemberById(@PathVariable Long memberId) {
        Member member = memberService.getMemberById(memberId);
        MemberDto memberDto = MemberDto.fromEntity(member);
        return memberDto;
    }
    @PostMapping("/new")
    public void addMember(@RequestBody Member member) {
        memberService.createMember(member);
    }


    @DeleteMapping("/{memberId}")
    public void removeMemberById(@PathVariable Long memberId) {
        memberService.removeMemberById(memberId);
    }

    @GetMapping("/{memberId}/gatherings")
    public List<GatheringDto> getMemberGatherings(@PathVariable Long memberId) {
        Member member = memberService.getMemberById(memberId);
        List<MemberGathering> memberGatherings = member.getMemberGatherings();

//        List<Gathering> gatherings = memberGatherings.stream()
//                .map(MemberGathering::getGathering)
//                .collect(Collectors.toList());
        List<GatheringDto> gatheringDtos = memberGatherings.stream()
                .map(MemberGathering::getGathering)
                .map(GatheringDto::fromEntity)
                .collect(Collectors.toList());

        log.info("gatherings = {}", gatheringDtos);
        return gatheringDtos;
    }

    @PostMapping("/find-id")
    public Boolean memberDuplicateIdFind(@RequestBody Map<String, String> idMap) {
        return memberService.findIdDuplicateMember(idMap.get("id"));
    }

    @PostMapping("/find-email")
    public Boolean memberDuplicateEmailFind(@RequestBody Map<String, String> emailMap) {
        return memberService.findEmailDuplicateMember(emailMap.get("email"));
    }

    @GetMapping("/{memberId}/missions")
    public ResponseEntity<List<MemberMissionDto>> getMemberMissions(@PathVariable Long memberId) {
        List<MemberMission> memberMissions = memberService.findMemberMissions(memberId);
        List<MemberMissionDto> memberMissionDtos = memberMissions.stream()
                .map(MemberMissionDto::fromEntity)
                .collect(Collectors.toList());
        return ResponseEntity.ok(memberMissionDtos);
    }

    @GetMapping("/{memberId}/point")
    public ResponseEntity<PointDto> getMemberPoint(@PathVariable Long memberId) {
        Point memberPoint = memberService.findMemberPoint(memberId);
        PointDto pointDto = PointDto.fromEntity(memberPoint);
        return ResponseEntity.ok(pointDto);
    }

}
