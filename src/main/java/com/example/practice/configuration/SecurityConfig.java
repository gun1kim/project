package com.example.practice.configuration;

import com.example.practice.jwt.JwtSecurityConfig;
import com.example.practice.jwt.TokenProvider;
import com.example.practice.jwt.errors.JwtAccessDeniedHandler;
import com.example.practice.jwt.errors.JwtAuthenticationEntryPoint;
import jakarta.servlet.Filter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.parameters.P;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.filter.CorsFilter;

/**
 * 토큰 사용을 위한 csrf 설정을 disabled
 * Exception 처리할 때 앞서 만들었던 JwtAuthenticationEntryPoint, JwtAccessDeniedHandler 클래스를 추가
 * 로그인 API, 회원가입 API는 토큰이 없는 상태에서 요청이 들어오기 때문에 모두 PermitAll()
 * configure()에서 HttpSecurity.addFilterBefore()로 JwtFilter(tokenProvider)를 등록했던 JwtSecurityConfig 설정 추가
 */
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@Slf4j
public class SecurityConfig {

    private final TokenProvider tokenProvider;
    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    private final JwtAccessDeniedHandler jwtAccessDeniedHandler;
    private final CorsFilter corsFilter;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public WebSecurityCustomizer configure() {
        return (web) -> web.ignoring()
                .requestMatchers(new AntPathRequestMatcher("/favicon.ico"),
                        new AntPathRequestMatcher("/api/member/join"),
                        new AntPathRequestMatcher("/api/authenticate"),
                        new AntPathRequestMatcher("/api/member/login"),
                        new AntPathRequestMatcher("/api/mail/mail-send"),
                        new AntPathRequestMatcher("/api/mail/mail-confirm"),
                        new AntPathRequestMatcher("/api/member/find-id"),
                        new AntPathRequestMatcher("/api/member/find-email"),
                        new AntPathRequestMatcher("/api/member/reissue"));
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .csrf(AbstractHttpConfigurer::disable)
                .addFilterBefore(corsFilter, UsernamePasswordAuthenticationFilter.class)

                .exceptionHandling(
                        (handling) ->
                                handling.authenticationEntryPoint(jwtAuthenticationEntryPoint)
                                        .accessDeniedHandler(jwtAccessDeniedHandler)
                )

                .sessionManagement((session) -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

                .authorizeHttpRequests((registry) ->
                        registry.requestMatchers(
                                        new AntPathRequestMatcher("/api/member/join"),
                                        new AntPathRequestMatcher("/api/authenticate"),
                                        new AntPathRequestMatcher("/api/member/login"),
                                        new AntPathRequestMatcher("/api/mail/mail-send"),
                                        new AntPathRequestMatcher("/api/mail/mail-confirm"),
                                        new AntPathRequestMatcher("/api/member/find-id"),
                                        new AntPathRequestMatcher("/api/member/find-email")
                                )
                                .permitAll()
                                .anyRequest().authenticated()
                )
                .apply(new JwtSecurityConfig(tokenProvider));

        return http.build();
    }
}
