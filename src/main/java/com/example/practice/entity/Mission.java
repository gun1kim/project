package com.example.practice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Mission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mission_id")
    private Long missionId;

    @Column(length = 20)
    private String title;

    private String description; // 미션설명

    private LocalDateTime createAt = LocalDateTime.now();
    private LocalDateTime modifyAt;

    private Status status; // 참여가능, 참여마감, 종료

    @Embedded
    private Address address;

    private LocalDateTime startAt;
    private LocalDateTime endAt;
    private LocalDateTime deadline;

    private String category; // 카테고리 (3개밖에 없어서 따로 테이블을 두지 않으려고 생각중임)

    private String host; // 주최자

    @OneToMany(mappedBy = "mission")
    private List<MemberMission> memberMissions = new ArrayList<>();

    @OneToMany(mappedBy = "mission")
    private List<MissionLike> likes = new ArrayList<>();

    @PreUpdate
    public void onUpdate() {
        this.modifyAt = LocalDateTime.now();
    }

    public int getLikesCount() {
        return likes.size();
    }
}
