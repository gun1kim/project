package com.example.practice.dto.gathering;

import com.example.practice.dto.member.MemberGatheringDto;
import com.example.practice.entity.Address;
import com.example.practice.entity.Gathering;
import com.example.practice.entity.Member;
import com.example.practice.entity.Status;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
public class GatheringCreateDto {

    private Long creatorId;

    private String title;

    private String intro;

    private String etc;


    private String zoneCode;
    private String fullAddress;
    private String subAddress;


    private int capacity;

    private MultipartFile image;

    private LocalDateTime deadline;
    private LocalDateTime startAt;

    private List<MemberGatheringDto> memberGatheringDtos;

    public Gathering toEntity(Member creator) {
        Address address = new Address(zoneCode, fullAddress, subAddress);
        return Gathering.builder()
                .creator(creator)
                .title(title)
                .intro(intro)
                .status(Status.OPEN)
                .etc(etc)
                .location(address)
                .capacity(capacity)
                .image(image.getOriginalFilename())
                .deadline(deadline)
                .startAt(startAt)
                .count(1)
                .createAt(LocalDateTime.now())
                .build();

    }

}
