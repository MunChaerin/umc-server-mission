package org.example.umcmission.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.example.umcmission.converter.MissionConverter;
import org.example.umcmission.domain.Mission;
import org.example.umcmission.dto.responseDTO.MissionResDTO;
import org.example.umcmission.repository.MissionRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MissionQueryServiceImpl implements MissionQueryService{
    private final MissionRepository missionRepository;

    @Override
    @Transactional(readOnly = true)
    public MissionResDTO.MissionPreViewListDTO getMissions(Long storedId, int page, int size){
        PageRequest pageRequest = PageRequest.of(page,size);
        Page<Mission> missions = missionRepository.findByStoreId(storedId, pageRequest);
        return MissionConverter.toMissionPreviewListDTO(missions);
    }
}
