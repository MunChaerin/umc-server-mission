package org.example.umcmission.converter;

import org.example.umcmission.domain.Member;
import org.example.umcmission.domain.Mission;
import org.example.umcmission.domain.enums.MissionStatus;
import org.example.umcmission.domain.mapping.MemberMission;
import org.example.umcmission.dto.requestDTO.MissionReqDTO;
import org.example.umcmission.dto.responseDTO.MissionResDTO;

public class MemberMissionConverter {
    public static MemberMission toMemberMission(MissionReqDTO.ChallengingMissionDTO dto, Member member, Mission mission) {
    return MemberMission.builder()
                .member(member)
                .mission(mission)
                .status(MissionStatus.CHALLENGING) // 상태를 CHALLENGING으로 설정
                .build();
}

    public static MissionResDTO.MissionPreviewDTO toMemberMissionDTO(MemberMission memberMission){
        return MissionResDTO.MissionPreviewDTO.builder()
                .id(memberMission.getId())
                .missionStatus(memberMission.getStatus())
                .createdAt(memberMission.getCreatedAt())
                .updatedAt(memberMission.getUpdatedAt())
                .build();
    }
}
