package com.example.practice.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class MemberMission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_mission_id")
    private Long memberMissionId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_id")
    private Mission mission;

    @OneToMany(mappedBy = "memberMission", cascade = CascadeType.ALL)
    private List<MissionImage> images;

    @Enumerated(EnumType.STRING)
    private MissionStatus status; // 미션 진행 상태

    private String content;
    private int point;

    private LocalDateTime finishedAt;

}
