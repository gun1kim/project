package com.example.practice.repository;

import com.example.practice.domain.Gathering;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GatheringRepository extends JpaRepository<Gathering, Long> {

    List<Gathering> findAllByStatusEquals(boolean status);

//    void joinGathering(Long id);
}
