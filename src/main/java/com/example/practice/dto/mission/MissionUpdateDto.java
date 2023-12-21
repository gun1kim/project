package com.example.practice.dto.mission;

import com.example.practice.entity.Address;
import com.example.practice.entity.Mission;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@Getter
@Setter
public class MissionUpdateDto {
    private String title;
    private String description;
    private MultipartFile image;
    private int point;
    private String zoneCode;
    private String fullAddress;
    private String subAddress;
    private LocalDateTime startAt;
    private LocalDateTime endAt;
    private LocalDateTime deadline;

    private String host;
//    private MultipartFile image;
    private String category;


    public void updateMission(Mission mission) {
        Address address = new Address(zoneCode, fullAddress, subAddress);
        mission.setTitle(title);
        mission.setDescription(description);
        mission.setPoint(point);
        mission.setStartAt(startAt);
        mission.setEndAt(endAt);
        mission.setDeadline(deadline);
        mission.setHost(host);
        mission.setAddress(address);
        mission.setCategory(category);

    }

}
