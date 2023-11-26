package com.example.practice.dto;

import lombok.*;



@Data
@RequiredArgsConstructor
public class UserDto {

    private Long userId;
    private String id;
    private String name;
    private String email;
    private String profile;
}
