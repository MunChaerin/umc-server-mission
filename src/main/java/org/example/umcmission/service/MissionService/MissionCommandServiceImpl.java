package org.example.umcmission.service.MissionService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.umcmission.apiPayload.code.status.ErrorStatus;
import org.example.umcmission.apiPayload.exception.handler.StoreHandler;
import org.example.umcmission.converter.MemberMissionConverter;
import org.example.umcmission.converter.MissionConverter;
import org.example.umcmission.domain.Member;
import org.example.umcmission.domain.Mission;
import org.example.umcmission.domain.Store;
import org.example.umcmission.domain.mapping.MemberMission;
import org.example.umcmission.dto.requestDTO.MissionReqDTO;
import org.example.umcmission.dto.responseDTO.MissionResDTO;
import org.example.umcmission.repository.MemberMissionRespository;
import org.example.umcmission.repository.MemberRepository;
import org.example.umcmission.repository.MissionRepository;
import org.example.umcmission.repository.StoreRepository.StoreRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MissionCommandServiceImpl implements MissionCommandService{
    private final StoreRepository storeRepository;
    private final MissionRepository missionRepository;
    private final MemberRepository memberRepository;
    private final MemberMissionRespository memberMissionRespository;
    @Override
    @Transactional
    public MissionResDTO.MissionPreviewDTO createMission(MissionReqDTO.CreateMissionDTO dto){
        Store store = storeRepository.findById(dto.getStoreId())
                .orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND));
        Mission mission = missionRepository.save(MissionConverter.toMission(dto, store));
        return MissionConverter.toMissionDTO(mission);
    }
    @Override
    @Transactional
    public MissionResDTO.MissionPreviewDTO createChallengingMission(MissionReqDTO.ChallengingMissionDTO dto) {
        Long missionId = dto.getMissionId();

        Mission mission = missionRepository.findById(missionId)
                .orElseThrow(() -> new RuntimeException("미션이 존재하지 않습니다."));

        Member member = memberRepository.findById(dto.getMemberId())
                .orElseThrow(() -> new RuntimeException("사용자가 존재하지 않습니다."));

        MemberMission memberMission = MemberMissionConverter.toMemberMission(dto, member,mission);
        MemberMission savedmemberMission = memberMissionRespository.save(memberMission);

        return MemberMissionConverter.toMemberMissionDTO(savedmemberMission);
    }
}
