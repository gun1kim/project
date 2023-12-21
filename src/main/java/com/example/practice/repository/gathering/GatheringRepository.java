package com.example.practice.repository.gathering;

import com.example.practice.entity.Gathering;
import com.example.practice.entity.Status;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface GatheringRepository extends JpaRepository<Gathering, Long> {


    Page<Gathering> findAllByStatusEquals(Status status, Pageable pageable);
    Page<Gathering> findByTitleLike(String title, Pageable pageable);

    Page<Gathering> findByStatusEqualsAndTitleLike(Status status, String title, Pageable pageable);

}
