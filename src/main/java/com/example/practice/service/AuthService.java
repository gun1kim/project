package com.example.practice.service;

import com.example.practice.dto.token.TokenDto;
import com.example.practice.dto.token.TokenRequestDto;
import com.example.practice.dto.member.MemberCreateDto;
import com.example.practice.dto.member.MemberDto;
import com.example.practice.dto.member.MemberLoginDto;
import com.example.practice.entity.Member;
import com.example.practice.entity.RefreshToken;
import com.example.practice.entity.Role;
import com.example.practice.jwt.TokenProvider;
import com.example.practice.repository.member.MemberRepository;
import com.example.practice.repository.token.RefreshTokenRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class AuthService {

    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenProvider tokenProvider;
    private final RefreshTokenRepository refreshTokenRepository;


    public MemberDto signUp(MemberCreateDto memberCreateDto) {
        if (memberRepository.existsById(memberCreateDto.getId())) {
            throw new RuntimeException("이미 가입되어 있는 유저입니다.");
        }
        String password = passwordEncoder.encode(memberCreateDto.getPassword());

        Member member = Member.builder()
                .memberId(memberCreateDto.getMemberId())
                .id(memberCreateDto.getId())
//                .name(memberCreateDto.getName())
                .email(memberCreateDto.getEmail())
                .password(password)
                .role(Role.ROLE_USER)
                .createAt(LocalDateTime.now())
                .build();

        memberRepository.save(member);

        return MemberDto.fromEntity(member);
    }

    public TokenDto login(MemberLoginDto memberLoginDto) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(memberLoginDto.getId(), memberLoginDto.getPassword());

        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        TokenDto tokenDto = tokenProvider.generateTokenDto(authentication);

        RefreshToken refreshToken = RefreshToken.builder()
                .key(authentication.getName())
                .value(tokenDto.getRefreshToken())
                .build();

        refreshTokenRepository.save(refreshToken);


        return tokenDto;
    }
    public TokenDto reissue(TokenRequestDto tokenRequestDto) {
        if (!tokenProvider.validateToken(tokenRequestDto.getRefreshToken())) {
            throw new RuntimeException("Refresh Token이 유효하지 않습니다.");
        }

        Authentication authentication = tokenProvider.getAuthentication(tokenRequestDto.getAccessToken());

        RefreshToken refreshToken = refreshTokenRepository.findByKey(authentication.getName())
                .orElseThrow(() -> new RuntimeException("로그아웃 된 사용자입니다."));

        TokenDto tokenDto = tokenProvider.generateTokenDto(authentication);

        RefreshToken newRefreshToken = refreshToken.updateValue(tokenDto.getRefreshToken());
        refreshTokenRepository.save(newRefreshToken);

        return tokenDto;
    }

//    public TokenDto reissue(TokenRequestDto tokenRequestDto) {
//        Authentication authentication = tokenProvider.getAuthentication(tokenRequestDto.getAccessToken());
//        String key = authentication.getName();
//        RefreshToken refreshToken = refreshTokenRepository.findByKey(key).orElseThrow(() -> new RuntimeException("리프레시 토큰이 없습니다."));
//
//        if (!refreshToken.getValue().equals(tokenRequestDto.getRefreshToken())) {
//            throw new IllegalArgumentException("유효하지 않는 토큰입니다");
//        }
//
//        return tokenProvider.generateTokenDto(authentication);
//
//    }

//    public void removeRefreshToken(String key) {
//        RefreshToken refreshToken = refreshTokenRepository.findByKey(key).orElseThrow(() -> new IllegalArgumentException("해당 리프레시 토큰이 없습니다.."));
//        if (tokenProvider.validateRefreshToken(refreshToken.getValue())) {
//            refreshTokenRepository.deleteById(refreshToken.getKey());
//        } else {
//            throw new IllegalArgumentException("해당 리프레시 ");
//        }
////        refreshTokenRepository.deleteById(key);
//    }

    public void removeRefreshToken(TokenRequestDto tokenRequestDto) {
        log.info("accessToken = {}, refreshToken = {}", tokenRequestDto.getAccessToken(), tokenRequestDto.getRefreshToken());
//        if (!tokenProvider.validateToken(tokenRequestDto.getAccessToken())) {
//            throw new IllegalArgumentException("로그아웃: 유효하지 않은 토큰");
//        }

        Authentication authentication = tokenProvider.getAuthentication(tokenRequestDto.getAccessToken());

        List<RefreshToken> all = refreshTokenRepository.findAll();
        for (RefreshToken refreshToken : all) {
            if (refreshToken.getValue().equals(tokenRequestDto.getRefreshToken())) {
//                refreshTokenRepository.deleteById(refreshToken.getKey());
                refreshTokenRepository.deleteById(authentication.getName());
            }
        }
        all = refreshTokenRepository.findAll();
        for (RefreshToken refreshToken : all) {
            if (refreshToken.getValue().equals(tokenRequestDto.getRefreshToken())) {
                throw new RuntimeException("로그아웃: 토큰 삭제 실패");
            }
        }
    }
}
