package com.example.practice.dto.member;

import com.example.practice.entity.Member;
import lombok.*;



@Getter
@Builder
@Setter
public class MemberDto {

    private Long memberId;
    private String id;
    private String name;
    private String email;
    private String profile;

    public Member toEntity() {
        return Member.builder()
                .memberId(memberId)
                .id(id)
                .name(name)
                .email(email)
                .profile(profile)
                .build();
    }

    public static MemberDto fromEntity(Member member) {
        return MemberDto.builder()
                .memberId(member.getMemberId())
                .id(member.getId())
                .name(member.getName())
                .email(member.getEmail())
                .profile(member.getProfile())
                .build();
    }
}
