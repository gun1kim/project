package com.example.practice.dto;

import com.example.practice.domain.User;
import lombok.*;



@Getter
@Builder
@Setter
public class UserDto {

    private Long userId;
    private String id;
    private String name;
    private String email;
    private String profile;

    public User toEntity() {
        return User.builder()
                .userId(userId)
                .id(id)
                .name(name)
                .email(email)
                .profile(profile)
                .build();
    }

    public static UserDto fromEntity(User user) {
        return UserDto.builder()
                .userId(user.getUserId())
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .profile(user.getProfile())
                .build();
    }
}
