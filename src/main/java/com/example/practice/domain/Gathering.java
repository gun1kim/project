package com.example.practice.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @Column(columnDefinition = "TINYINT default 0")
    private boolean status;

    @Column(columnDefinition = "INT default 1")
    private int count = 1;

    private int capacity;

//    @Column(nullable = false, columnDefinition = "TIMESTAMP default CURRENT_TIMESTAMP")
    @Column(nullable = false)
    private Timestamp createAt;

    @OneToMany(mappedBy = "gathering", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<UserGathering> userGatherings = new ArrayList<>();

    public Gathering(String title, String content, int capacity) {
        this.title = title;
        this.content = content;
        this.capacity = capacity;
    }

    @PrePersist
    public void prePersist() {
        this.createAt = new Timestamp(System.currentTimeMillis());
    }
}
