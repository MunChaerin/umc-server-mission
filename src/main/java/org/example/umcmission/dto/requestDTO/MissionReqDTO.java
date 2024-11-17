package org.example.umcmission.dto.requestDTO;

import lombok.Getter;
import org.example.umcmission.domain.enums.MissionStatus;

import java.time.LocalDate;

public class MissionReqDTO {
    @Getter
    public static class CreateMissionDTO{
        private Integer reward;
        private LocalDate deadline;
        private String missionspec;
        private Long storeId;
    }
    @Getter
    public static class ChallengingMissionDTO{
        private MissionStatus missionStatus;
    }
}
