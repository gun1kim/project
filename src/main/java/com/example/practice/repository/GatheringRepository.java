package com.example.practice.repository;

import com.example.practice.domain.Gathering;
import com.example.practice.domain.Status;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface GatheringRepository extends JpaRepository<Gathering, Long> {

    Page<Gathering> findAllByStatusEquals(Status status, Pageable pageable);
    Page<Gathering> findByTitleLike(String title, Pageable pageable);

}
