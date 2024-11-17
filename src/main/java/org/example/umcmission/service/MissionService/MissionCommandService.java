package org.example.umcmission.service.MissionService;

import org.example.umcmission.dto.requestDTO.MissionReqDTO;
import org.example.umcmission.dto.responseDTO.MissionResDTO;

public interface MissionCommandService {
    MissionResDTO.MissionPreviewDTO createMission(MissionReqDTO.CreateMissionDTO dto);
    MissionResDTO.MissionPreviewDTO createChallengingMission(Long missionId,MissionReqDTO.ChallengingMissionDTO dto);
}
