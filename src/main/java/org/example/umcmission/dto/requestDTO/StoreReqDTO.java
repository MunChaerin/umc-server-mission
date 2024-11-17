package org.example.umcmission.dto.requestDTO;

import lombok.Getter;
import org.example.umcmission.validation.annotaion.ExistRegions;

public class StoreReqDTO {
    @Getter
    public static class CreatStoreReqDTO{
        private String name;
        private String address;
        private Float score;
        @ExistRegions
        private Long regionId;
    }
}
