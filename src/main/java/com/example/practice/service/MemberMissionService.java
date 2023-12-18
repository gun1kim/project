package com.example.practice.service;

import com.example.practice.dto.MemberMissionPostDto;
import com.example.practice.entity.*;
import com.example.practice.repository.MemberMissionRepository;
import com.example.practice.repository.MemberRepository;
import com.example.practice.repository.MissionRepository;
import jakarta.mail.Multipart;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class MemberMissionService {

    private final MemberMissionRepository memberMissionRepository;
    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;
    private final S3FileUploader s3FileUploader;

    public void joinMission(Long memberId, Long missionId) {
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new IllegalArgumentException("no such member"));
        Mission mission = missionRepository.findById(missionId).orElseThrow(() -> new IllegalArgumentException("no such mission"));

        MemberMission memberMission = new MemberMission();

        member.addMemberMission(memberMission);
        mission.addMemberMission(memberMission);

        memberMissionRepository.save(memberMission);

    }

    public void addMemberMissionPost(MemberMissionPostDto memberMissionPostDto) {
        Member member = memberRepository.findById(memberMissionPostDto.getMemberId()).orElseThrow(() -> new IllegalArgumentException("no such member"));
        Mission mission = missionRepository.findById(memberMissionPostDto.getMissionId()).orElseThrow(() -> new IllegalArgumentException("no such mission"));

        MemberMission memberMission = new MemberMission(member, mission);
        memberMission.setContent(memberMissionPostDto.getContent());
        memberMission.setStatus(MissionStatus.ONGOING);

        List<String> imageUrls = new ArrayList<>();
        for (MultipartFile image : memberMissionPostDto.getImages()) {
            String imageUrl = s3FileUploader.uploadFileToS3(image, "path");
            MissionImage missionImage = new MissionImage(imageUrl, memberMission);
            memberMission.getImages().add(missionImage);

        }

        memberMissionRepository.save(memberMission);

    }


}
