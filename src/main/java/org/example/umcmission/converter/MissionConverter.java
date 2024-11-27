package org.example.umcmission.converter;

import org.example.umcmission.domain.Mission;
import org.example.umcmission.domain.Review;
import org.example.umcmission.domain.Store;
import org.example.umcmission.dto.requestDTO.MissionReqDTO;
import org.example.umcmission.dto.responseDTO.MissionResDTO;
import org.example.umcmission.dto.responseDTO.ReviewResDTO;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

public class MissionConverter {
    public static Mission toMission(MissionReqDTO.CreateMissionDTO dto, Store store) {
        return Mission.builder()
                .reward(dto.getReward())
                .deadline(dto.getDeadline())
                .missionSpec(dto.getMissionspec())
                .store(store)
                .build();
    }

    public static MissionResDTO.MissionPreviewDTO toMissionDTO(Mission mission){
        return MissionResDTO.MissionPreviewDTO.builder()
                .id(mission.getId())
                .reward(mission.getReward())
                .deadline(mission.getDeadline())
                .missionspec(mission.getMissionSpec())
                .storeId(mission.getStore().getId())
                .missionStatus(mission.getMissionStatus())
                .createdAt(mission.getCreatedAt())
                .updatedAt(mission.getUpdatedAt())
                .build();
    }

    public static List<MissionResDTO.MissionPreviewDTO> toMissionPreviewList(List<Mission> missions) {
        return missions.stream()
                .map(mission -> MissionResDTO.MissionPreviewDTO.builder()
                        .id(mission.getId())
                        .reward(mission.getReward())
                        .missionStatus(mission.getMissionStatus())
                        .build())
                .collect(Collectors.toList());
    }

    // 페이지 전체를 변환
    public static MissionResDTO.MissionPreViewListDTO toMissionPreviewListDTO(Page<Mission> missionPage) {
        return MissionResDTO.MissionPreViewListDTO.builder()
                .missionList(toMissionPreviewList(missionPage.getContent())) // 리뷰 리스트 변환
                .listSize(missionPage.getContent().size()) // 현재 페이지의 리뷰 개수
                .totalPage(missionPage.getTotalPages())    // 전체 페이지 수
                .totalElements(missionPage.getTotalElements()) // 전체 리뷰 수
                .isFirst(missionPage.isFirst())            // 첫 페이지 여부
                .isLast(missionPage.isLast())              // 마지막 페이지 여부
                .build();
    }
}
