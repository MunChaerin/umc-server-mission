package org.example.umcmission.converter;

import org.example.umcmission.domain.Mission;
import org.example.umcmission.domain.Store;
import org.example.umcmission.domain.enums.MissionStatus;
import org.example.umcmission.dto.requestDTO.MissionReqDTO;
import org.example.umcmission.dto.responseDTO.MissionResDTO;

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
}
