package com.example.practice.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "userGatherings")
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

    @Column(nullable = false)
    @CreatedDate
    private Timestamp createAt;

    @OneToMany(mappedBy = "gathering", fetch = FetchType.LAZY)
    @JsonManagedReference("gathering_gatherings")
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
