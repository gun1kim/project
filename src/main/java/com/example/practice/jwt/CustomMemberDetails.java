package com.example.practice.jwt;

import com.example.practice.dto.member.MemberDto;
import com.example.practice.entity.Member;
import com.example.practice.entity.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

public class CustomMemberDetails implements UserDetails {

    private Long memberId;
    private String id;
    private String password;
    private String name;
    private Role role;

    public CustomMemberDetails(Member member) {
        this.memberId = member.getMemberId();
        this.password = member.getPassword();
        this.id = member.getId();
        this.name = member.getName();
        this.role = member.getRole();

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        ArrayList<GrantedAuthority> auth = new ArrayList<>();
        auth.add(new SimpleGrantedAuthority(role.toString()));
        return auth;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return id;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    public Long getMemberId() {
        return memberId;
    }
}
