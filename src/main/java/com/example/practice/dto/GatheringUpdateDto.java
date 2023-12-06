package com.example.practice.dto;

import com.example.practice.domain.Gathering;
import com.example.practice.domain.User;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@Getter
@Builder
public class GatheringUpdateDto {
//    private Long gatheringId;
//    private Long creatorId;
    private String title;
    private String intro;
    private String etc;
    private String location;
    private MultipartFile image;
    private LocalDateTime deadline;
    private LocalDateTime startAt;
    private int capacity;

    public Gathering toEntity() {
        return Gathering.builder()
//                .gatheringId(gatheringId)
//                .creator(creator)
                .title(title)
                .intro(intro)
                .etc(etc)
                .location(location)
                .image(image.getOriginalFilename())
                .deadline(deadline)
                .startAt(startAt)
                .capacity(capacity)
                .build();
    }

    public void updateGathering(Gathering gathering) {
        gathering.setTitle(this.title);
        gathering.setIntro(this.intro);
        gathering.setEtc(this.etc);
        gathering.setLocation(this.location);
        gathering.setImage(this.image.getOriginalFilename());
        gathering.setDeadline(this.deadline);
        gathering.setStartAt(this.startAt);
        gathering.setCapacity(this.capacity);

    }
}
