package com.example.practice.dto;

import com.example.practice.domain.Gathering;
import com.example.practice.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@Builder
public class GatheringDto {

    private Long gatheringId;
    private Long creatorId;
    private String creatorName;
    private String title;
    private String intro;
    private String etc;
    private String location;
    private String image;
    private boolean status;
    private int count;
    private int capacity;

    public Gathering toEntity(User creator) {
        return Gathering.builder()
                .gatheringId(gatheringId)
                .creator(creator)
                .title(title)
                .intro(intro)
                .etc(etc)
                .location(location)
                .image(image)
                .status(status)
                .count(count)
                .capacity(capacity)
                .build();

    }

    public static GatheringDto fromEntity(Gathering gathering) {
        return GatheringDto.builder()
                .gatheringId(gathering.getGatheringId())
                .creatorId(gathering.getCreator() != null ? gathering.getCreator().getUserId() : null)
                .creatorName(gathering.getCreator() != null ? gathering.getCreator().getName() : null)
                .title(gathering.getTitle())
                .intro(gathering.getIntro())
                .etc(gathering.getEtc())
                .location(gathering.getLocation())
                .image(gathering.getImage())
                .status(gathering.isStatus())
                .count(gathering.getCount())
                .capacity(gathering.getCapacity())
                .build();
    }


}
