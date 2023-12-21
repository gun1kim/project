package com.example.practice.jwt;

import com.example.practice.entity.Member;
import com.example.practice.jwt.CustomMemberDetails;
import com.example.practice.repository.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

@Service
@RequiredArgsConstructor
@Transactional
public class CustomUserDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member member = memberRepository.findById(username).orElseThrow(() -> new UsernameNotFoundException(username + " -> 데이터베이스에서 찾을 수 없습니다."));
        CustomMemberDetails details = new CustomMemberDetails(member);
        return details;

//        return memberRepository.findById(username)
////                .map(user -> createUser(username, user))
//                .map(this::createUserDetails)
//                .orElseThrow(() -> new UsernameNotFoundException(username + "-> 데이터베이스에서 찾을 수 없습니다."));


    }

    private UserDetails createUserDetails(Member member) {
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(member.getRole().toString());
        return new User(
//                String.valueOf(member.getId()),
                member.getId(),
                member.getPassword(),
                Collections.singleton(grantedAuthority)
        );

    }

    private Member getMember(String id) {
        return memberRepository.findById(id).orElseThrow(() -> new UsernameNotFoundException(id + "-> not found"));
    }


}
