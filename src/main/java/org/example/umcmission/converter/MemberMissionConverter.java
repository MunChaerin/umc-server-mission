package org.example.umcmission.converter;

import org.example.umcmission.domain.Member;
import org.example.umcmission.domain.Mission;
import org.example.umcmission.domain.enums.MissionStatus;
import org.example.umcmission.domain.mapping.MemberMission;
import org.example.umcmission.dto.requestDTO.MissionReqDTO;
import org.example.umcmission.dto.responseDTO.MemberMissionResDTO;
import org.example.umcmission.dto.responseDTO.MissionResDTO;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

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

    public static MemberMissionResDTO.MemberMissionListDTO toUserMissionListDTO(Page<MemberMission> memberMissionPage) {
        return MemberMissionResDTO.MemberMissionListDTO.builder()
                .missionList(toUserMissionPreviewList(memberMissionPage.getContent()))
                .listSize(memberMissionPage.getNumberOfElements())
                .totalPage(memberMissionPage.getTotalPages())
                .totalElements(memberMissionPage.getTotalElements())
                .isFirst(memberMissionPage.isFirst())
                .isLast(memberMissionPage.isLast())
                .build();
    }

    public static List<MemberMissionResDTO.MemberMissionPreviewDTO> toUserMissionPreviewList(List<MemberMission> userMissions) {
        return userMissions.stream()
                .map(mission -> MemberMissionResDTO.MemberMissionPreviewDTO.builder()
                        .missionId(mission.getMission().getId())
                        .reward(mission.getMission().getReward())
                        .deadline(mission.getMission().getDeadline())
                        .status(mission.getStatus().name())
                        .build())
                .collect(Collectors.toList());
    }
}
