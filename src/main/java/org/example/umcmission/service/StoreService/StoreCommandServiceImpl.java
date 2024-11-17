package org.example.umcmission.service.StoreService;

import lombok.RequiredArgsConstructor;
import org.example.umcmission.apiPayload.code.status.ErrorStatus;
import org.example.umcmission.apiPayload.exception.handler.RegionHandler;
import org.example.umcmission.converter.StoreConverter;
import org.example.umcmission.domain.Region;
import org.example.umcmission.domain.Store;
import org.example.umcmission.dto.requestDTO.StoreReqDTO;
import org.example.umcmission.dto.responseDTO.StoreResDTO;
import org.example.umcmission.repository.RegionRepository;
import org.example.umcmission.repository.StoreRepository.StoreRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class StoreCommandServiceImpl implements StoreCommandService{
    private final StoreRepository storeRepository;
    private final RegionRepository regionRepository;

    @Override
    public StoreResDTO.StorePreviewDTO createStore(StoreReqDTO.CreatStoreReqDTO dto){
        Region region = regionRepository.findById(dto.getRegionId()).orElseThrow(()-> new RegionHandler(ErrorStatus.REGION_NOT_FOUND));
        Store store = storeRepository.save(StoreConverter.toStore(dto, region));
        return StoreConverter.toStoreDTO(store);
    }
}
