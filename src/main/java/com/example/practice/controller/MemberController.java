package com.example.practice.controller;

import com.example.practice.entity.Gathering;
import com.example.practice.entity.Member;
import com.example.practice.entity.MemberGathering;
import com.example.practice.service.MemberService;
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
        List<Member> list = memberService.getAllMember();
        return list;
    }

    @GetMapping("/{memberId}")
    public Member getMemberById(@PathVariable Long memberId) {
        Member member = memberService.getMemberById(memberId);
        return member;
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
    public List<Gathering> getMemberGatherings(@PathVariable Long memberId) {
        Member member = memberService.getMemberById(memberId);
        List<MemberGathering> memberGatherings = member.getMemberGatherings();

        List<Gathering> gatherings = memberGatherings.stream()
                .map(MemberGathering::getGathering)
                .collect(Collectors.toList());

        log.info("gatherings = {}", gatherings);
        return gatherings;
    }

    @PostMapping("//find-id")
    public Boolean memberDuplicateIdFind(@RequestBody Map<String, String> idMap) {
        return memberService.findIdDuplicateMember(idMap.get("id"));
    }

    @PostMapping("/find-email")
    public Boolean memberDuplicateEmailFind(@RequestBody Map<String, String> emailMap) {
        return memberService.findEmailDuplicateMember(emailMap.get("email"));
    }
}
