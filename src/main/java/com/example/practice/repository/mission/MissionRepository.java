package com.example.practice.repository.mission;

import com.example.practice.entity.Mission;
import com.example.practice.entity.Status;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissionRepository extends JpaRepository<Mission, Long> {

    Page<Mission> findAllByTitleLike(String title, Pageable pageable);

    Page<Mission> findByCategoryLike(String category, Pageable pageable);

    Page<Mission> findByStatus(Status status, Pageable pageable);

}
