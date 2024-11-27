package org.example.umcmission.service.MissionService;

import org.example.umcmission.dto.responseDTO.MissionResDTO;

public interface MissionQueryService {
    MissionResDTO.MissionPreViewListDTO getMissions(Long storedId, int page, int size);
}
