package com.example.practice.dto.mission;

import com.example.practice.entity.Address;
import com.example.practice.entity.Mission;
import com.example.practice.entity.Status;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@Getter
@Setter
public class MissionCreateDto {

    private String title;
    private String description;

    private MultipartFile image;

    private String zoneCode;
    private String fullAddress;
    private String subAddress;

    private int point;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime startAt;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime endAt;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime deadline;

    private String host;

    private String category;

    public Mission toEntity() {
        Address address = new Address(zoneCode, fullAddress, subAddress);

        return Mission.builder()
                .title(title)
                .description(description)
                .image(image.getOriginalFilename())
                .address(address)
                .point(point)
                .startAt(startAt)
                .endAt(endAt)
                .status(Status.OPEN)
                .deadline(deadline)
                .host(host)
                .category(category)
                .build();

    }
}
