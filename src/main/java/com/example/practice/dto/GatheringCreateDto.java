package com.example.practice.dto;

import com.example.practice.domain.Gathering;
import com.example.practice.domain.User;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
public class GatheringCreateDto {

    private Long creatorId;

    private String title;

    private String intro;

    private String etc;

    private String location;

    private int capacity;

    private MultipartFile image;

    private LocalDateTime deadline;
    private LocalDateTime startAt;

    private List<UserGatheringDto> userGatherings;

    public Gathering toEntity(User creator) {
        return Gathering.builder()
                .creator(creator)
                .title(title)
                .intro(intro)
                .etc(etc)
                .location(location)
                .capacity(capacity)
                .image(image.getOriginalFilename())
                .deadline(deadline)
                .startAt(startAt)
                .build();

    }

}
