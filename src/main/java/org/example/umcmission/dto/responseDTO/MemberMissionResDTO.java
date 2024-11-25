package org.example.umcmission.dto.responseDTO;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

public class MemberMissionResDTO {
    @Builder
    @Getter
    public static class MemberMissionListDTO {
        private List<MemberMissionPreviewDTO> missionList;
        private Integer listSize;
        private Integer totalPage;
        private Long totalElements;
        private Boolean isFirst;
        private Boolean isLast;
    }

    @Builder
    @Getter
    public static class MemberMissionPreviewDTO {
        private Long missionId;
        private Integer reward;
        private LocalDate deadline;
        private String status;
    }
}
