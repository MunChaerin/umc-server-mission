package org.example.umcmission.dto.responseDTO;

import lombok.*;
import org.example.umcmission.domain.enums.MissionStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class MissionResDTO {
    @Builder
    @Getter
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class MissionPreviewDTO{
        private Long id;
        private Integer reward;
        private LocalDate deadline;
        private String missionspec;
        private Long storeId;
        private MissionStatus missionStatus;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
    }
}
