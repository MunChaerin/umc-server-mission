package org.example.umcmission.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.umcmission.apiPayload.ApiResponse;
import org.example.umcmission.dto.requestDTO.ReviewReqDTO;
import org.example.umcmission.dto.responseDTO.ReviewResDTO;
import org.example.umcmission.service.ReviewService.ReviewCommandService;
import org.example.umcmission.service.ReviewService.ReviewQueryService;
import org.example.umcmission.validation.annotaion.CheckPage;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
@Tag(name = "리뷰 관련 API")
public class ReviewController {
    private final ReviewCommandService reviewCommandService;
    private final ReviewQueryService reviewQueryService;

    @PostMapping("")
    @Operation(method = "POST", summary = "리뷰 추가 API", description = "가게에 리뷰를 추가하는 API입니다.")
    public ApiResponse<ReviewResDTO.ReviewPreviewDTO> createReview(@Valid @RequestBody ReviewReqDTO.CreateReviewReqDTO dto){
        ReviewResDTO.ReviewPreviewDTO reviewPreviewDTO = reviewCommandService.createReview(dto);
        return ApiResponse.onSuccess(reviewPreviewDTO);
    }

    @GetMapping("/{memberId}")
    @Operation(method = "GET", summary = "내가 작성한 리뷰 목록 조회", description = "특정 유저가 작성한 리뷰를 조회하는 API입니다")
    public ApiResponse<ReviewResDTO.ReviewPreViewListDTO> getReviews(
            @PathVariable Long memberId,
            @CheckPage@RequestParam int page,
            @CheckPage@RequestParam int size){
        ReviewResDTO.ReviewPreViewListDTO reviewPagePreviewDTO = reviewQueryService.getReviews(memberId, page,size);
        return ApiResponse.onSuccess(reviewPagePreviewDTO);
    }
}
