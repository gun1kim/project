package com.example.practice.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class GatheringUpdateDto {

    private String title;

    private String intro;

    private String etc;

    private MultipartFile image;

    private String location;

    private int capacity;

}
