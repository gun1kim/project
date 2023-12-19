package com.example.practice.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
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
    private List<MissionImage> images = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private MissionStatus status; // 미션 진행 상태

    private String content;

    private LocalDateTime finishedAt;

    public MemberMission() {}
    public MemberMission(Member member, Mission mission) {
        this.member = member;
        this.mission = mission;
    }

    public void approve() {
        this.status = MissionStatus.COMPLETED;
        this.finishedAt = LocalDateTime.now();
    }

    public void reject() {
        this.status = MissionStatus.REJECTED;
        this.finishedAt = LocalDateTime.now();
    }


}
