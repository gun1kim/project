package com.example.practice.repository;

import com.example.practice.domain.Gathering;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface GatheringRepository extends JpaRepository<Gathering, Long> {

    Page<Gathering> findAllByStatusEquals(boolean status, Pageable pageable);

    Page<Gathering> findGatheringsByTitleContains(String title, Pageable pageable);
    Page<Gathering> findByTitleLike(String title, Pageable pageable);


//    List<Gathering> findAll(Pageable pageable);
//    @Query("SELECT g FROM Gathering g JOIN FETCH g.creator")
//    List<Gathering> findAllWithCreator();


}
