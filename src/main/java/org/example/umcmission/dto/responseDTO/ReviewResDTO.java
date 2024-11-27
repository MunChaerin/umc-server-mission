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

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ReviewPreViewListDTO {
        private List<ReviewPreviewDTO> reviewList; // 리뷰 목록
        private Integer listSize;                  // 현재 페이지의 리뷰 수
        private Integer totalPage;                 // 전체 페이지 수
        private Long totalElements;                // 전체 리뷰 수
        private Boolean isFirst;                   // 첫 페이지 여부
        private Boolean isLast;                    // 마지막 페이지 여부
    }
}
