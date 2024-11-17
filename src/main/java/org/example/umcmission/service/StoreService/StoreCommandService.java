package org.example.umcmission.service.StoreService;

import org.example.umcmission.domain.Store;
import org.example.umcmission.dto.requestDTO.StoreReqDTO;
import org.example.umcmission.dto.responseDTO.StoreResDTO;

public interface StoreCommandService {
    StoreResDTO.StorePreviewDTO createStore(StoreReqDTO.CreatStoreReqDTO dto);
}
