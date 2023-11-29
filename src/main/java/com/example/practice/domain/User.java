package com.example.practice.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.annotation.processing.Generated;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@ToString(exclude = "userGatherings")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;


    @Column(length = 15, nullable = false)
    private String id;

    @Column(length = 20, nullable = false)
    private String password;

    @Column(length = 10, nullable = false)
    private String name;
    @Column(length = 30, nullable = false)
    private String email;

    @Column(length = 200)
    private String address;

    @Column(nullable = false, columnDefinition = "TINYINT default 0")
    private boolean isAdmin;

    private String profile;

//    @Column(nullable = false, columnDefinition = "TIMESTAMP default CURRENT_TIMESTAMP")
    @Column(nullable = false)
    private Timestamp createAt;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @JsonManagedReference("user_gatherings")
    private List<UserGathering> userGatherings = new ArrayList<>();

    @PrePersist
    public void prePersist() {
        this.createAt = new Timestamp(System.currentTimeMillis());
    }
}
