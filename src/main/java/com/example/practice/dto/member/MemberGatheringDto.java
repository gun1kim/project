package com.example.practice.dto.member;

import com.example.practice.entity.Gathering;
import com.example.practice.entity.Member;
import com.example.practice.entity.MemberGathering;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MemberGatheringDto {
    private Long memberGatheringId;
    private Long memberId;
    private Long gatheringId;

    public MemberGathering toEntity(Member member, Gathering gathering) {
        return MemberGathering.builder()
                .memberGatheringId(memberGatheringId)
                .member(member)
                .gathering(gathering)
                .build();
    }

    public static MemberGatheringDto fromEntity(MemberGathering memberGathering) {
        return MemberGatheringDto.builder()
                .memberGatheringId(memberGathering.getMemberGatheringId())
                .memberId(memberGathering.getMember().getMemberId())
                .gatheringId(memberGathering.getGathering().getGatheringId())
                .build();
    }
}
