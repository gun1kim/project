package com.example.practice.dto;

import com.example.practice.domain.Gathering;
import com.example.practice.domain.User;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Builder
public class GatheringUpdateDto {
    private Long gatheringId;
    private Long creatorId;
    private String title;
    private String intro;
    private String etc;
    private String location;
    private MultipartFile image;
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
                .image(image.getOriginalFilename())
                .status(status)
                .count(count)
                .capacity(capacity)
                .build();
    }
}
