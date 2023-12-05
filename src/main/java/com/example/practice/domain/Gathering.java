package com.example.practice.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.springframework.data.annotation.CreatedDate;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"userGatherings"})
@Builder
public class Gathering {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gatheringId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "creator_id")
    private User creator;

    @Column(length = 50, nullable = false)
    private String title;

    @Column
    private String intro;

    @Column
    private String etc;

    @Column
    private String location;

    @Column
    private String image;

    @Column(columnDefinition = "TINYINT default 0") // 0 = 모집중, 1 = 모집마감
    private boolean status;

    @Column(columnDefinition = "INT default 1")
    private int count = 1;

    private int capacity;

    @Column(nullable = false)
    @CreatedDate
    private Timestamp createAt;

    @OneToMany(mappedBy = "gathering", fetch = FetchType.LAZY)
    private List<UserGathering> userGatherings = new ArrayList<>();

    @PrePersist
    public void prePersist() {
        this.createAt = new Timestamp(System.currentTimeMillis());
    }

}
