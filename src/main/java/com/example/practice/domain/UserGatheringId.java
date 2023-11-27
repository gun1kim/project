package com.example.practice.domain;

import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Embeddable
@Data
public class UserGatheringId implements Serializable {
    private Long userId;
    private Long gatheringId;

}
