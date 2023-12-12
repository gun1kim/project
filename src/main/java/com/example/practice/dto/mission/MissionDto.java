package com.example.practice.dto.mission;

import com.example.practice.entity.Mission;
import com.example.practice.entity.Status;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class MissionDto {

    private String title;
    private String description;
    private String host;
    private String zoneCode;
    private String fullAddress;
    private String subAddress;
    private Status status;
    private LocalDateTime startAt;
    private LocalDateTime endAt;
    private LocalDateTime deadline;


    public static MissionDto fromEntity(Mission mission) {
        MissionDto missionDto = new MissionDto();
        missionDto.setTitle(mission.getTitle());
        missionDto.setDescription(mission.getDescription());
        missionDto.setHost(mission.getHost());
        missionDto.setZoneCode(mission.getAddress().getZoneCode());
        missionDto.setFullAddress(mission.getAddress().getFullAddress());
        missionDto.setSubAddress(mission.getAddress().getSubAddress());
        missionDto.setStatus(mission.getStatus());
        missionDto.setStartAt(mission.getStartAt());
        missionDto.setEndAt(mission.getEndAt());
        missionDto.setDeadline(mission.getDeadline());

        return missionDto;
    }



}
