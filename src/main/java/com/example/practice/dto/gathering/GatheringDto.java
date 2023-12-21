package com.example.practice.dto.gathering;

import com.example.practice.dto.member.MemberDto;
import com.example.practice.entity.Address;
import com.example.practice.entity.Gathering;
import com.example.practice.entity.Status;
import com.example.practice.entity.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

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
    private String zoneCode;
    private String fullAddress;
    private String subAddress;
    private String image;
    private Status status;
    private LocalDateTime deadline;
    private LocalDateTime startAt;
    private int count;
    private int capacity;

//    private List<MemberDto> participants;

    public Gathering toEntity(Member creator) {
        Address address = new Address(zoneCode, fullAddress, subAddress);
        return Gathering.builder()
                .gatheringId(gatheringId)
                .creator(creator)
                .title(title)
                .intro(intro)
                .etc(etc)
                .location(address)
                .image(image)
                .status(status)
                .deadline(deadline)
                .startAt(startAt)
                .count(count)
                .capacity(capacity)
                .build();

    }

    public static GatheringDto fromEntity(Gathering gathering) {
        Address address = gathering.getLocation();
//        List<MemberDto> participants = gathering.getMemberGatherings().stream()
//                .map(userGathering -> MemberDto.fromEntity(userGathering.getMember()))
//                .collect(Collectors.toList());

        return GatheringDto.builder()
                .gatheringId(gathering.getGatheringId())
                .creatorId(gathering.getCreator() != null ? gathering.getCreator().getMemberId() : null)
                .creatorName(gathering.getCreator() != null ? gathering.getCreator().getName() : null)
                .title(gathering.getTitle())
                .intro(gathering.getIntro())
                .etc(gathering.getEtc())
                .zoneCode(address.getZoneCode())
                .fullAddress(address.getFullAddress())
                .subAddress(address.getSubAddress())
                .image(gathering.getImage())
                .status(gathering.getStatus())
                .deadline(gathering.getDeadline())
                .startAt(gathering.getStartAt())
                .count(gathering.getCount())
                .capacity(gathering.getCapacity())
//                .participants(participants)
                .build();
    }


}
