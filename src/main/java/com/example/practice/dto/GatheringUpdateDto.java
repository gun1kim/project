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
//    private Long gatheringId;
//    private Long creatorId;
    private String title;
    private String intro;
    private String etc;
    private String location;
    private MultipartFile image;
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
                .capacity(capacity)
                .build();
    }

    public void updateGathering(Gathering gathering) {
        gathering.setTitle(this.title);
        gathering.setIntro(this.intro);
        gathering.setEtc(this.etc);
        gathering.setLocation(this.location);
        gathering.setImage(this.image.getOriginalFilename());
        gathering.setCapacity(this.capacity);
    }
}
