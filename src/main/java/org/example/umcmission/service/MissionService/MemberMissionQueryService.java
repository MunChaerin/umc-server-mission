package org.example.umcmission.service.MissionService;

import org.example.umcmission.dto.responseDTO.MemberMissionResDTO;

public interface MemberMissionQueryService {
    MemberMissionResDTO.MemberMissionListDTO getChallengingMissions(Long memberId, int page, int size);
}
