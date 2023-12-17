package com.example.practice.controller;

import com.amazonaws.Response;
import com.example.practice.dto.TokenDto;
import com.example.practice.dto.TokenRequestDto;
import com.example.practice.dto.member.MemberCreateDto;
import com.example.practice.dto.member.MemberDto;
import com.example.practice.dto.member.MemberLoginDto;
import com.example.practice.entity.Member;
import com.example.practice.jwt.CustomMemberDetails;
import com.example.practice.jwt.JwtFilter;
import com.example.practice.jwt.SecurityUtil;
import com.example.practice.jwt.TokenProvider;
import com.example.practice.service.AuthService;
import com.example.practice.service.CustomUserDetailsService;
import com.example.practice.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.nio.file.attribute.UserPrincipal;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class AuthController {

    private final AuthService authService;
    private final MemberService memberService;
    @PostMapping("/member/join")
    public ResponseEntity<MemberDto> singUp(@RequestBody MemberCreateDto memberCreateDto) {
        return ResponseEntity.ok(authService.signUp(memberCreateDto));
    }

    @PostMapping("/member/login")
    public ResponseEntity<TokenDto> login(@RequestBody MemberLoginDto memberLoginDto) {

        return ResponseEntity.ok(authService.login(memberLoginDto));
    }

    @PostMapping("/member/reissue")
    public ResponseEntity<TokenDto> reissue(@RequestBody TokenRequestDto tokenRequestDto) {
        return ResponseEntity.ok(authService.reissue(tokenRequestDto));
    }

//    @GetMapping("/member/me")
//    public ResponseEntity<?> getMe() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        log.info("authentication = {}", authentication);
//        Member member = memberService.getMemberById(SecurityUtil.getCurrentMemberId());
//        MemberDto memberDto = MemberDto.fromEntity(member);
//        return ResponseEntity.ok(memberDto);
//
//    }

    @GetMapping("/member/me")
    public ResponseEntity<?> getMe(@AuthenticationPrincipal CustomMemberDetails memberDetails) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        log.info("userDetail = {}", memberDetails);
//        log.info("authentication = {}", authentication);
//        log.info("authentication.getPrincipal() = {}", authentication.getPrincipal());
        return ResponseEntity.ok(memberDetails);
    }

//    @DeleteMapping("/member/logout")
//    public ResponseEntity<?> logout(@AuthenticationPrincipal UserPrincipal userPrincipal) {
//        log.info("userPrincipal.getName() = {}", userPrincipal.getName());
//        if (userPrincipal == null) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized");
//        }
//        authService.removeRefreshToken(userPrincipal.getName());
//        return ResponseEntity.ok().build();
//    }

//    @DeleteMapping("/member/logout")
//    public ResponseEntity<?> logout(TokenRequestDto tokenRequestDto) {
//        authService.removeRefreshToken(tokenRequestDto);
//        return ResponseEntity.ok().build();
//    }

    @DeleteMapping("/member/logout")
    public ResponseEntity<?> logout(@RequestHeader(value = "Authorization") String accessToken,
                                    @RequestHeader(value = "x-refresh-token") String refreshToken) {
        String jwt = accessToken.substring(7);
        TokenRequestDto tokenRequestDto = new TokenRequestDto();
        tokenRequestDto.setAccessToken(jwt);
        tokenRequestDto.setRefreshToken(refreshToken);
        authService.removeRefreshToken(tokenRequestDto);
        return ResponseEntity.ok().build();
    }

}
