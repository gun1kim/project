package com.example.practice.entity;

import jakarta.persistence.*;

@Entity
public class MissionImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long missionImageId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_mission_id")
    private MemberMission memberMission;

    private String imageUrl;

}
