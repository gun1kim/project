package com.example.practice.dto;

import com.example.practice.domain.Gathering;
import com.example.practice.domain.User;
import com.example.practice.domain.UserGathering;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserGatheringDto {
    private Long userGatheringId;
    private Long userId;
    private Long gatheringId;

    public UserGathering toEntity(User user, Gathering gathering) {
        return UserGathering.builder()
                .userGatheringId(userGatheringId)
                .user(user)
                .gathering(gathering)
                .build();
    }

    public static UserGatheringDto fromEntity(UserGathering userGathering) {
        return UserGatheringDto.builder()
                .userGatheringId(userGathering.getUserGatheringId())
                .userId(userGathering.getUser().getUserId())
                .gatheringId(userGathering.getGathering().getGatheringId())
                .build();
    }
}
