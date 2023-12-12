package com.example.practice.dto.mission;

import com.example.practice.entity.Address;
import com.example.practice.entity.Mission;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@Getter
@Setter
public class MissionCreateDto {

    private String title;
    private String description;


    private String zoneCode;
    private String fullAddress;
    private String subAddress;

    private LocalDateTime startAt;
    private LocalDateTime endAt;
    private LocalDateTime deadline;

    private String host;

    private String category;

    public Mission toEntity() {
        Address address = new Address(zoneCode, fullAddress, subAddress);

        return Mission.builder()
                .title(title)
                .description(description)
                .address(address)
                .startAt(startAt)
                .endAt(endAt)
                .deadline(deadline)
                .host(host)
                .category(category)
                .build();

    }
}
