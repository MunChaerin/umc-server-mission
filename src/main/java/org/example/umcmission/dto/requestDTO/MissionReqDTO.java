package org.example.umcmission.dto.requestDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.example.umcmission.domain.enums.MissionStatus;
import org.example.umcmission.validation.annotaion.AlreadyChallenging;
import org.example.umcmission.validation.annotaion.ExistStores;

import java.time.LocalDate;

public class MissionReqDTO {
    @Getter
    @Setter
    public static class CreateMissionDTO{
        private Integer reward;
        @NotNull
        private LocalDate deadline;
        @NotBlank
        private String missionspec;
        @ExistStores
        private Long storeId;
    }
    @Getter
    @Setter
    public static class ChallengingMissionDTO{
        @AlreadyChallenging
        private Long missionId;

        @NotNull
        private Long memberId;
    }
}
