package com.example.practice.service.member;

import com.example.practice.entity.Member;
import com.example.practice.entity.MemberMission;
import com.example.practice.entity.Point;
import com.example.practice.repository.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {

    private final MemberRepository memberRepository;


    public void createMember(Member member) {
        memberRepository.save(member);
    }
    @Transactional(readOnly = true)
    public Member getMemberById(Long memberId) {
        return memberRepository.findById(memberId).orElseThrow(() -> new IllegalArgumentException("no such data"));
    }

    @Transactional(readOnly = true)
    public Member getMemberById(String id) {
        return memberRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("no such member"));
    }

    @Transactional(readOnly = true)
    public List<Member> findAllMember() {
        return memberRepository.findAll();
    }

    public void removeMemberById(Long id) {
        memberRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public Boolean findIdDuplicateMember(String id) {
        return memberRepository.existsById(id);
    }

    @Transactional(readOnly = true)
    public Boolean findEmailDuplicateMember(String email) {
        return memberRepository.existsMemberByEmail(email);
    }


    @Transactional(readOnly = true)
    public List<MemberMission> findMemberMissions(Long memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new IllegalArgumentException("no such member"));

        return member.getMemberMissions();
    }

    @Transactional(readOnly = true)
    public Point findMemberPoint(Long memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new IllegalArgumentException("no such member"));
        return member.getPoint();
    }

}
