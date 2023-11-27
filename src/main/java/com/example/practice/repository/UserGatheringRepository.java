package com.example.practice.repository;

import com.example.practice.domain.UserGathering;
import com.example.practice.domain.UserGatheringId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserGatheringRepository extends JpaRepository<UserGathering, Long> {


}
