package com.example.practice.dto.member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberCreateDto {
    private Long memberId;

    private String id;
    private String email;
    private String password;

}
