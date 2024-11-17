package org.example.umcmission.dto.requestDTO;

import lombok.Getter;

public class ReviewReqDTO {
    @Getter
    public static class CreateReviewReqDTO{
        private String title;
        private String body;
        private Float score;
        private Long storeId;
        private Long memberId;
    }
}
