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

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MissionPreViewListDTO {
        private List<MissionResDTO.MissionPreviewDTO> missionList; // 리뷰 목록
        private Integer listSize;                  // 현재 페이지의 리뷰 수
        private Integer totalPage;                 // 전체 페이지 수
        private Long totalElements;                // 전체 리뷰 수
        private Boolean isFirst;                   // 첫 페이지 여부
        private Boolean isLast;                    // 마지막 페이지 여부
    }
}
