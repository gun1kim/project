package com.example.practice.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long memberId;


    @Column(length = 15, nullable = false, unique = true)
    private String id;

    @Column(nullable = false)
    private String password;

    @Column(length = 10)
    private String name;
    @Column(length = 30)
    private String email;

    @Column(length = 200)
    private String address;

    private String profile;

//    private String phone;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(nullable = false)
    private LocalDateTime createAt = LocalDateTime.now();

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "point_id")
    private Point point;

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<MemberGathering> memberGatherings = new ArrayList<>();

    @OneToMany(mappedBy = "creator", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Gathering> createGatherings = new ArrayList<>();

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<MemberMission> memberMissions = new ArrayList<>();

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<MissionLike> likeMissions = new ArrayList<>();

    // 양빙향 연관관계 설정 메서드
    public void addMemberMission(MemberMission memberMission) {
        this.memberMissions.add(memberMission);
        memberMission.setMember(this);
    }


    public void increasePoint(int point) {
        if (this.point == null) {
            this.point = new Point(point, point);
        } else {
            this.point.increasePoint(point);
        }
    }

}
