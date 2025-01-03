package org.example.umcmission.dto.responseDTO;

import lombok.*;
import org.example.umcmission.domain.Mission;
import org.example.umcmission.domain.Review;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class StoreResDTO {
    @Builder
    @Getter
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class StorePreviewDTO{
        private Long id;
        private String name;
        private String address;
        private Float score;
        private Long regionId;
        private List<Mission> missionList;
        private List<Review> reviewList;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ReviewPreViewListDTO {
        List<ReviewPreViewDTO> reviewList;
        Integer listSize;
        Integer totalPage;
        Long totalElements;
        Boolean isFirst;
        Boolean isLast;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ReviewPreViewDTO {
        String ownerNickname;
        Float score;
        String body;
        LocalDate createdAt;
    }
}
