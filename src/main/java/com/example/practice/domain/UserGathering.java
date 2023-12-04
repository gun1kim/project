package com.example.practice.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users_gathering")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserGathering {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long userGatheringId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gathering_id")
    private Gathering gathering;

    public void UserGathering(User user, Gathering gathering) {
        this.user = user;
        this.gathering = gathering;
    }
}
