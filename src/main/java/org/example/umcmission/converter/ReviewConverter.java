package org.example.umcmission.converter;

import org.example.umcmission.domain.Member;
import org.example.umcmission.domain.Review;
import org.example.umcmission.domain.Store;
import org.example.umcmission.dto.requestDTO.ReviewReqDTO;
import org.example.umcmission.dto.responseDTO.ReviewResDTO;
import org.example.umcmission.dto.responseDTO.StoreResDTO;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

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

    public static List<ReviewResDTO.ReviewPreviewDTO> toReviewPreviewList(List<Review> reviews) {
        return reviews.stream()
                .map(review -> ReviewResDTO.ReviewPreviewDTO.builder()
                        .id(review.getId())
                        .title(review.getTitle())
                        .score(review.getScore())
                        .body(review.getBody()) // 본문 프리뷰
                        .build())
                .collect(Collectors.toList());
    }

    // 페이지 전체를 변환
    public static ReviewResDTO.ReviewPreViewListDTO toReviewPreviewListDTO(Page<Review> reviewPage) {
        return ReviewResDTO.ReviewPreViewListDTO.builder()
                .reviewList(toReviewPreviewList(reviewPage.getContent())) // 리뷰 리스트 변환
                .listSize(reviewPage.getContent().size()) // 현재 페이지의 리뷰 개수
                .totalPage(reviewPage.getTotalPages())    // 전체 페이지 수
                .totalElements(reviewPage.getTotalElements()) // 전체 리뷰 수
                .isFirst(reviewPage.isFirst())            // 첫 페이지 여부
                .isLast(reviewPage.isLast())              // 마지막 페이지 여부
                .build();
    }
}
