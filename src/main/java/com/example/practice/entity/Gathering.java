package com.example.practice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Gathering {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gatheringId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "creator_id")
    private Member creator;

    @Column(length = 50, nullable = false)
    private String title;

    @Column
    private String intro;

    @Column
    private String etc;


    @Embedded
    private Address location;

    @Column
    private String image;

    @Column(columnDefinition = "VARCHAR(10) 'OPEN'")
    @Enumerated(EnumType.STRING)
    private Status status = Status.OPEN;

    @Column(columnDefinition = "INT default 1")
    private int count = 1;

    private int capacity;


    @Column(columnDefinition = "DATETIME default LocalDateTime.now()")
    private LocalDateTime createAt = LocalDateTime.now();

    private LocalDateTime deadline;
    private LocalDateTime startAt;

    @OneToMany(mappedBy = "gathering", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<MemberGathering> memberGatherings = new ArrayList<>();



}
