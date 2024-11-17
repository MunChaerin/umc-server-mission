package org.example.umcmission.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.umcmission.apiPayload.ApiResponse;
import org.example.umcmission.dto.requestDTO.StoreReqDTO;
import org.example.umcmission.dto.responseDTO.StoreResDTO;
import org.example.umcmission.service.StoreService.StoreCommandService;
import org.example.umcmission.validation.annotaion.ExistRegions;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
@Tag(name = "가게 관련 API")
public class StoreController {
    private final StoreCommandService storeCommandService;
    //1. 특정 지역에 가게 추가하기 API
    @PostMapping("")
    @Operation(method = "POST",summary = "가게 생성 API", description = "특정 지역에 가게를 생성하는 API")
    public ApiResponse<StoreResDTO.StorePreviewDTO> createStore(@Valid@ExistRegions @RequestBody StoreReqDTO.CreatStoreReqDTO dto){
        StoreResDTO.StorePreviewDTO storePreviewDTO = storeCommandService.createStore(dto);

        return ApiResponse.onSuccess(storePreviewDTO);
    }
}
