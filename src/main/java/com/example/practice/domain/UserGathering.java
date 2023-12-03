package com.example.practice.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users_gathering")
@Data
public class UserGathering {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long userGatheringId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonBackReference("user_gatherings")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gathering_id")
    @JsonBackReference("gathering_gatherings")
    private Gathering gathering;

    public void UserGathering(User user, Gathering gathering) {
        this.user = user;
        this.gathering = gathering;
    }
}
