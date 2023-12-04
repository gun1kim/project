package com.example.practice.repository;

import com.example.practice.domain.Gathering;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface GatheringRepository extends JpaRepository<Gathering, Long> {

    List<Gathering> findAllByStatusEquals(boolean status);

//    @Query("SELECT g FROM Gathering g JOIN FETCH g.creator")
//    List<Gathering> findAllWithCreator();


}
