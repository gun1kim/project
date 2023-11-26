package com.example.practice.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "users_gathering")
public class UserGathering {

    @Id
    private Long userGatheringId;

    @ManyToOne
    @JoinColumn(name = "users_user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "gathering_gathering_id")
    private Gathering gathering;
}
