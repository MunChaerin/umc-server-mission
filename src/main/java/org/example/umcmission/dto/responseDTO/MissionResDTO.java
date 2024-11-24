package org.example.umcmission.dto.responseDTO;

import lombok.*;
import org.example.umcmission.domain.enums.MissionStatus;
import org.example.umcmission.domain.mapping.MemberMission;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

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
        private List<MemberMission> memberMissionList;
        private MissionStatus missionStatus;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
    }
}
