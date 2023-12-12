package com.example.practice.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "member_gathering")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberGathering {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long memberGatheringId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gathering_id")
    private Gathering gathering;

    public void MemberGathering(Member member, Gathering gathering) {
        this.member = member;
        this.gathering = gathering;
    }

}
