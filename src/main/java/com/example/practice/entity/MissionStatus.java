package com.example.practice.entity;

public enum MissionStatus {
    ONGOING, // 미션 진행중
    SUBMITTED, // 미션 완료 및 결과물 제출 완료, 관리자 승인 대기중
    COMPLETED, // 관리자 승인 완료
    REJECTED // 관리자 승인 거절
}
