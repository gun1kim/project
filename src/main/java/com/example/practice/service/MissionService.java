package com.example.practice.service;

import com.example.practice.entity.Mission;
import com.example.practice.entity.Status;
import com.example.practice.dto.mission.MissionCreateDto;
import com.example.practice.dto.mission.MissionDto;
import com.example.practice.dto.mission.MissionUpdateDto;
import com.example.practice.repository.MissionRepository;
import com.example.practice.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class MissionService {

    private final MissionRepository missionRepository;
    private final MemberRepository memberRepository;
    private final S3FileUploader s3FileUploader;



    public void addMission(MissionCreateDto missionCreateDto) {

        if (missionCreateDto.getStartAt().isAfter(missionCreateDto.getEndAt())) {
            throw new IllegalArgumentException("미션 종료 시간은 시작 시간보다 이후여야 합니다.");
        }
        Mission mission = missionCreateDto.toEntity();
        missionRepository.save(mission);
    }

    public void modifyMission(Long id, MissionUpdateDto missionUpdateDto) {
        Mission mission = missionRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("no such mission"));

        if (missionUpdateDto.getPoint() < 0) {
            throw new IllegalArgumentException("point cannot be minus");
        }
        if (missionUpdateDto.getStartAt().isAfter(missionUpdateDto.getEndAt())) {
            throw new IllegalArgumentException("미션 종료 시간은 시작 시간보다 이후여야 합니다.");
        }
        missionUpdateDto.updateMission(mission);

    }


    public void removeById(Long missionId) {
        Mission mission = missionRepository.findById(missionId).orElseThrow(() -> new IllegalArgumentException("no such mission"));

        missionRepository.deleteById(missionId);
    }

    @Transactional(readOnly = true)
    public List<MissionDto> findAll() {
        List<Mission> missions = missionRepository.findAll();
        return missions.stream().map(MissionDto::fromEntity).toList();
    }

    @Transactional(readOnly = true)
    public MissionDto findById(Long missionId) {
        Mission mission = missionRepository.findById(missionId).orElseThrow(() -> new IllegalArgumentException("no such mission"));
        return MissionDto.fromEntity(mission);

    }

    @Transactional(readOnly = true)
    public Page<MissionDto> findAllMissions(Pageable pageable) {
        Page<Mission> missions = missionRepository.findAll(pageable);
        return missions.map(MissionDto::fromEntity);
    }

    @Transactional(readOnly = true)
    public Page<MissionDto> findByCategoryLike(String category, Pageable pageable) {
        Page<Mission> categoryLike = missionRepository.findByCategoryLike(category, pageable);
        return categoryLike.map(MissionDto::fromEntity);
    }

    @Transactional(readOnly = true)
    public Page<MissionDto> findAllByTitleLike(String title, Pageable pageable) {
        Page<Mission> byTitleLike = missionRepository.findAllByTitleLike(title, pageable);
        return byTitleLike.map(MissionDto::fromEntity);
    }

    @Transactional(readOnly = true)
    public Page<MissionDto> findByStatus(String status, Pageable pageable) {
        Status statusEnum = Status.valueOf(status);
        Page<Mission> byStatus = missionRepository.findByStatus(statusEnum, pageable);
        return byStatus.map(MissionDto::fromEntity);

    }



    @Scheduled(cron = "0 0 0 * * *")
    public void modifyMissionStatus() {
        List<Mission> missions = missionRepository.findAll();
        for (Mission mission : missions) {
            if (mission.getDeadline().isBefore(LocalDateTime.now())) {
                mission.setStatus(Status.CLOSED);
            }
            // 종료된 미션에 대한 처리 필요
        }
    }


}
