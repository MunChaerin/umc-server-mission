package org.example.umcmission.converter;

import org.example.umcmission.domain.Region;
import org.example.umcmission.domain.Store;
import org.example.umcmission.dto.requestDTO.StoreReqDTO;
import org.example.umcmission.dto.responseDTO.StoreResDTO;

public class StoreConverter {
    public static Store toStore(StoreReqDTO.CreatStoreReqDTO dto, Region region) {
        return Store.builder()
                .name(dto.getName())
                .address(dto.getAddress())
                .score(dto.getScore())
                .region(region)
                .build();
    }

    public static StoreResDTO.StorePreviewDTO toStoreDTO(Store store){
        return StoreResDTO.StorePreviewDTO.builder()
                .id(store.getId())
                .name(store.getName())
                .address(store.getAddress())
                .score(store.getScore())
                .regionId(store.getRegion().getId())
                .missionList(store.getMissionList())
                .reviewList(store.getReviewList())
                .createdAt(store.getCreatedAt())
                .updatedAt(store.getUpdatedAt())
                .build();
    }
}
