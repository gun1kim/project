package com.example.practice.service;

import com.example.practice.entity.Member;
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
    public Member getMemberById(Long id) {
        return memberRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("no such data"));
    }

    @Transactional(readOnly = true)
    public List<Member> getAllMember() {
        return memberRepository.findAll();
    }

    public void removeMemberById(Long id) {
        memberRepository.deleteById(id);
    }


    public Boolean findIdDuplicateMember(String id) {
        return memberRepository.existsMemberById(id);
    }

    public Boolean findEmailDuplicateMember(String email) {
        return memberRepository.existsMemberByEmail(email);
    }


}
