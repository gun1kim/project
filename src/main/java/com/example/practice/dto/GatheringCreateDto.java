package com.example.practice.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Timestamp;
import java.util.List;

@Data
public class GatheringCreateDto {

    private String title;

    private String intro;

    private String etc;

    private String location;

    private int capacity;

    private MultipartFile image;

    private Timestamp createAt;

    private List<UserGatheringDto> userGatherings;

}
