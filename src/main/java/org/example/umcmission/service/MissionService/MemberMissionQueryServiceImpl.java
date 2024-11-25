package org.example.umcmission.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.example.umcmission.converter.MemberMissionConverter;
import org.example.umcmission.domain.enums.MissionStatus;
import org.example.umcmission.domain.mapping.MemberMission;
import org.example.umcmission.dto.responseDTO.MemberMissionResDTO;
import org.example.umcmission.repository.MemberMissionRespository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberMissionQueryServiceImpl implements  MemberMissionQueryService {
    private final MemberMissionRespository memberMissionRespository;

    @Override
    @Transactional(readOnly = true)
    public MemberMissionResDTO.MemberMissionListDTO getChallengingMissions(Long memberId, int page, int size){
        Page<MemberMission> memberMissions = memberMissionRespository.findByMemberIdAndStatus(memberId, MissionStatus.CHALLENGING, PageRequest.of(page, size));
        return MemberMissionConverter.toUserMissionListDTO(memberMissions);
    }

}
