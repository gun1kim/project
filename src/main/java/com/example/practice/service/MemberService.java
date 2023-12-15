package com.example.practice.service;

import com.example.practice.dto.member.MemberDto;
import com.example.practice.entity.Member;
import com.example.practice.jwt.SecurityUtil;
import com.example.practice.repository.MemberRepository;
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

//    public MemberDto getMyInfoBySecurity() {
//        return memberRepository.findById(SecurityUtil.getCurrentMemberId())
//                .map(MemberDto::fromEntity)
//                .orElseThrow(() -> new RuntimeException("로그인 유저 정보가 없습니다."));
//    }

    @Transactional(readOnly = true)
    public Member getMemberById(String id) {
        return memberRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("no such member"));
    }

    @Transactional(readOnly = true)
    public List<Member> getAllMember() {
        return memberRepository.findAll();
    }

    public void removeMemberById(Long id) {
        memberRepository.deleteById(id);
    }


    public Boolean findIdDuplicateMember(String id) {
        return memberRepository.existsById(id);
    }

    public Boolean findEmailDuplicateMember(String email) {
        return memberRepository.existsMemberByEmail(email);
    }


}
