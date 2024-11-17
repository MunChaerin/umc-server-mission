package org.example.umcmission.dto.requestDTO;

import lombok.Getter;
public class StoreReqDTO {
    @Getter
    public static class CreatStoreReqDTO{
        private String name;
        private String address;
        private Float score;
        private Long regionId;
    }
}
