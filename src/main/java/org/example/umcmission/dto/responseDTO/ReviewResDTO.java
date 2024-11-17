package org.example.umcmission.dto.responseDTO;

import lombok.*;
import org.example.umcmission.domain.ReviewImage;

import java.time.LocalDateTime;
import java.util.List;

public class ReviewResDTO {
    @Builder
    @Getter
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class ReviewPreviewDTO{
        private Long id;
        private String title;
        private String body;
        private Float score;
        private Long storeId;
        private Long memberId;
        private List<ReviewImage> reviewImageList;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
    }
}
