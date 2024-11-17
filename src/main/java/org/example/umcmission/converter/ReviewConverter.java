package org.example.umcmission.converter;

import org.example.umcmission.domain.Member;
import org.example.umcmission.domain.Review;
import org.example.umcmission.domain.Store;
import org.example.umcmission.dto.requestDTO.ReviewReqDTO;
import org.example.umcmission.dto.responseDTO.ReviewResDTO;

public class ReviewConverter {
    public static Review toReview(ReviewReqDTO.CreateReviewReqDTO dto, Store store, Member member) {
        return Review.builder()
                .title(dto.getTitle())
                .body(dto.getBody())
                .score(dto.getScore())
                .store(store)
                .member(member)
                .build();
    }

    public static ReviewResDTO.ReviewPreviewDTO toReviewDTO(Review review){
        return ReviewResDTO.ReviewPreviewDTO.builder()
                .id(review.getId())
                .title(review.getTitle())
                .body(review.getBody())
                .score(review.getScore())
                .storeId(review.getStore().getId())
                .memberId(review.getMember().getId())
                .reviewImageList(review.getReviewImageList())
                .createdAt(review.getCreatedAt())
                .updatedAt(review.getUpdatedAt())
                .build();
    }
}
