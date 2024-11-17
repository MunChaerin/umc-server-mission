package org.example.umcmission.dto.requestDTO;

import lombok.Getter;
import org.example.umcmission.validation.annotaion.ExistStores;

public class ReviewReqDTO {
    @Getter
    public static class CreateReviewReqDTO{
        private String title;
        private String body;
        private Float score;
        @ExistStores
        private Long storeId;
        private Long memberId;
    }
}
