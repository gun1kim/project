package com.example.practice.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Gathering {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gatheringId;

    @Column(length = 50, nullable = false)
    private String title;
    private String content;
    @Column(columnDefinition = "false")
    private boolean status;
    @Column(columnDefinition = "1")
    private int count;
    private int capacity;
    @Column(columnDefinition = "Timestamp default CURRENT_TIMESTAMP")
    private Timestamp createAt;

    @OneToMany(mappedBy = "gathering")
    private List<UserGathering> userGatherings = new ArrayList<>();

    public Gathering(String title, String content, int capacity) {
        this.title = title;
        this.content = content;
        this.capacity = capacity;
    }
}
