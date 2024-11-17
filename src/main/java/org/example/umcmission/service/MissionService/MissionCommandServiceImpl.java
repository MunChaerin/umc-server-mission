package org.example.umcmission.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.example.umcmission.apiPayload.code.status.ErrorStatus;
import org.example.umcmission.apiPayload.exception.handler.MissionHandler;
import org.example.umcmission.apiPayload.exception.handler.StoreHandler;
import org.example.umcmission.converter.MissionConverter;
import org.example.umcmission.domain.Mission;
import org.example.umcmission.domain.Store;
import org.example.umcmission.dto.requestDTO.MissionReqDTO;
import org.example.umcmission.dto.responseDTO.MissionResDTO;
import org.example.umcmission.repository.MissionRepository;
import org.example.umcmission.repository.StoreRepository.StoreRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MissionCommandServiceImpl implements MissionCommandService{
    private final StoreRepository storeRepository;
    private final MissionRepository missionRepository;
    @Override
    public MissionResDTO.MissionPreviewDTO createMission(MissionReqDTO.CreateMissionDTO dto){
        Store store = storeRepository.findById(dto.getStoreId())
                .orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND));
        Mission mission = missionRepository.save(MissionConverter.toMission(dto, store));
        return MissionConverter.toMissionDTO(mission);
    }
    @Override
    public MissionResDTO.MissionPreviewDTO createChallengingMission(Long missionId,MissionReqDTO.ChallengingMissionDTO dto) {
        Mission mission = missionRepository.findById(missionId)
                .orElseThrow(() -> new MissionHandler(ErrorStatus.MISSION_NOT_FOUND));

        // 미션 상태 업데이트
        mission.updateChallengingMission();

        // Mission 객체를 저장
        missionRepository.save(mission);

        // 변경된 상태를 반영하기 위해 다시 조회
        Mission updatedMission = missionRepository.findById(missionId)
                .orElseThrow(() -> new MissionHandler(ErrorStatus.MISSION_NOT_FOUND));

        return MissionConverter.toMissionDTO(updatedMission);
    }
}
