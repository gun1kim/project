package com.example.practice.service;

import com.example.practice.entity.Member;
import com.example.practice.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

@Service
@RequiredArgsConstructor
@Transactional
public class CustomUserDetailService {

    private final MemberRepository memberRepository;

    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        return memberRepository.findMemberById(id)
                .map(this::createUserDetails)
                .orElseThrow(() -> new UsernameNotFoundException(id + " 사용자를 찾을 수 없습니다."));
    }

    private UserDetails createUserDetails(Member member) {
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(member.getAuthorities().toString());
        return new User(
                String.valueOf(member.getMemberId()),
                member.getPassword(),
                Collections.singleton(grantedAuthority)
        );
    }
}
