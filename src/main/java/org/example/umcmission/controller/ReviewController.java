package org.example.umcmission.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.umcmission.apiPayload.ApiResponse;
import org.example.umcmission.dto.requestDTO.ReviewReqDTO;
import org.example.umcmission.dto.responseDTO.ReviewResDTO;
import org.example.umcmission.service.ReviewService.ReviewCommandService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
@Tag(name = "리뷰 관련 API")
@Validated
public class ReviewController {
    private final ReviewCommandService reviewCommandService;

    //2. 가게에 리뷰 추가하기 API
    @PostMapping("")
    @Operation(method = "POST", summary = "리뷰 추가 API", description = "가게에 리뷰를 추가하는 API입니다.")
    public ApiResponse<ReviewResDTO.ReviewPreviewDTO> createReview(@Valid @RequestBody ReviewReqDTO.CreateReviewReqDTO dto){


        ReviewResDTO.ReviewPreviewDTO reviewPreviewDTO = reviewCommandService.createReview(dto);

        return ApiResponse.onSuccess(reviewPreviewDTO);
    }
}
