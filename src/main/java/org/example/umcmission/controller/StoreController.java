package org.example.umcmission.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.umcmission.apiPayload.ApiResponse;
import org.example.umcmission.converter.StoreConverter;
import org.example.umcmission.domain.Review;
import org.example.umcmission.dto.requestDTO.StoreReqDTO;
import org.example.umcmission.dto.responseDTO.StoreResDTO;
import org.example.umcmission.service.StoreService.StoreCommandService;
import org.example.umcmission.service.StoreService.StoreQueryService;
import org.example.umcmission.validation.annotaion.ExistStores;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
@Tag(name = "가게 관련 API")
@Validated
public class StoreController {
    private final StoreCommandService storeCommandService;
    private final StoreQueryService storeQueryService;
    //1. 특정 지역에 가게 추가하기 API
    @PostMapping("")
    @Operation(method = "POST",summary = "가게 생성 API", description = "특정 지역에 가게를 생성하는 API")
    public ApiResponse<StoreResDTO.StorePreviewDTO> createStore(@Valid @RequestBody StoreReqDTO.CreatStoreReqDTO dto){
        StoreResDTO.StorePreviewDTO storePreviewDTO = storeCommandService.createStore(dto);

        return ApiResponse.onSuccess(storePreviewDTO);
    }

    @GetMapping("/{storeId}/reviews")
    @Operation(summary = "특정 가게의 리뷰 목록 조회 API",description = "특정 가게의 리뷰들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "storeId", description = "가게의 아이디, path variable 입니다!")
    })
    public ApiResponse<StoreResDTO.ReviewPreViewListDTO> getReviewList(@ExistStores @PathVariable(name = "storeId") Long storeId, @RequestParam(name = "page") Integer page){
        Page<Review> reviewList = storeQueryService.getReviewList(storeId,page);
        return ApiResponse.onSuccess(StoreConverter.reviewPreViewListDTO(reviewList));
    }
}
