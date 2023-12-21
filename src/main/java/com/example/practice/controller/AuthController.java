package com.example.practice.controller;

import com.example.practice.dto.token.TokenDto;
import com.example.practice.dto.token.TokenRequestDto;
import com.example.practice.dto.member.MemberCreateDto;
import com.example.practice.dto.member.MemberDto;
import com.example.practice.dto.member.MemberLoginDto;
import com.example.practice.jwt.CustomMemberDetails;
import com.example.practice.service.AuthService;
import com.example.practice.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
@Slf4j
public class AuthController {

    private final AuthService authService;
    private final MemberService memberService;
    @PostMapping("/join")
    public ResponseEntity<MemberDto> singUp(@RequestBody MemberCreateDto memberCreateDto) {
        return ResponseEntity.ok(authService.signUp(memberCreateDto));
    }

    @PostMapping("/login")
    public ResponseEntity<TokenDto> login(@RequestBody MemberLoginDto memberLoginDto) {

        return ResponseEntity.ok(authService.login(memberLoginDto));
    }

    @PostMapping("/reissue")
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
    @GetMapping("/me")
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

    @DeleteMapping("/logout")
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
