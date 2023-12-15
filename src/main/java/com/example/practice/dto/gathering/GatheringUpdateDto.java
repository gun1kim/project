package com.example.practice.dto.gathering;

import com.example.practice.entity.Address;
import com.example.practice.entity.Gathering;
import lombok.Builder;
import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@Getter
@Builder
public class GatheringUpdateDto {

    private String title;
    private String intro;
    private String etc;
    private String zoneCode;
    private String fullAddress;
    private String subAddress;

    private MultipartFile image;
    private LocalDateTime deadline;
    private LocalDateTime startAt;
    private int capacity;

    public Gathering toEntity() {
        Address address = new Address(zoneCode, fullAddress, subAddress);
        return Gathering.builder()
                .title(title)
                .intro(intro)
                .etc(etc)
                .location(address)
                .image(image.getOriginalFilename())
                .deadline(deadline)
                .startAt(startAt)
                .capacity(capacity)
                .build();
    }

    public void updateGathering(Gathering gathering) {
        Address address = new Address(zoneCode, fullAddress, subAddress);

        gathering.setTitle(this.title);
        gathering.setIntro(this.intro);
        gathering.setEtc(this.etc);
        gathering.setLocation(address);
//        gathering.setImage(this.image.getOriginalFilename());
        gathering.setDeadline(this.deadline);
        gathering.setStartAt(this.startAt);
        gathering.setCapacity(this.capacity);

    }

}
