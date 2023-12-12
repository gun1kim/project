package com.example.practice.controller;

import com.example.practice.dto.TokenDto;
import com.example.practice.dto.TokenRequestDto;
import com.example.practice.dto.member.MemberCreateDto;
import com.example.practice.dto.member.MemberDto;
import com.example.practice.dto.member.MemberLoginDto;
import com.example.practice.jwt.JwtFilter;
import com.example.practice.jwt.TokenProvider;
import com.example.practice.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    @PostMapping("/member/join")
    public ResponseEntity<MemberDto> singUp(@RequestBody MemberCreateDto memberCreateDto) {
        return ResponseEntity.ok(authService.signUp(memberCreateDto));
    }

    @PostMapping("/member/login")
    public ResponseEntity<TokenDto> login(@RequestBody MemberLoginDto memberLoginDto) {

        return ResponseEntity.ok(authService.login(memberLoginDto));
    }

    @PostMapping("/member/authenticate")
    public ResponseEntity<TokenDto> reissue(@RequestBody TokenRequestDto tokenRequestDto) {
        return ResponseEntity.ok(authService.reissue(tokenRequestDto));
    }



}
