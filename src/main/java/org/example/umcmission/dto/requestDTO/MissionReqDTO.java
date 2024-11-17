package org.example.umcmission.dto.requestDTO;

import lombok.Getter;
import org.example.umcmission.domain.enums.MissionStatus;
import org.example.umcmission.validation.annotaion.AlreadyChallenging;
import org.example.umcmission.validation.annotaion.ExistStores;

import java.time.LocalDate;

public class MissionReqDTO {
    @Getter
    public static class CreateMissionDTO{
        private Integer reward;
        private LocalDate deadline;
        private String missionspec;
        @ExistStores
        private Long storeId;
    }
    @Getter
    public static class ChallengingMissionDTO{
        @AlreadyChallenging
        private Long id;public void setId(Long id) {
            this.id = id;
        }

        private MissionStatus missionStatus;
    }
}
