package org.example.umcmission.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.umcmission.apiPayload.ApiResponse;
import org.example.umcmission.dto.requestDTO.MissionReqDTO;
import org.example.umcmission.dto.responseDTO.MissionResDTO;
import org.example.umcmission.service.MissionService.MissionCommandService;
import org.example.umcmission.validation.annotaion.AlreadyChallenging;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
@Tag(name = "미션 관련 API")
@Validated
public class MissionController {
    private final MissionCommandService missionCommandService;

    //3. 가게에 미션 추가하기 API
    @PostMapping("")
    @Operation(method = "POST", summary = "미션 추가 API", description = "해당 가게에 미션을 추가하는 API입니다.")
    public ApiResponse<MissionResDTO.MissionPreviewDTO> createMission(@Valid@RequestBody MissionReqDTO.CreateMissionDTO dto){
        MissionResDTO.MissionPreviewDTO missionPreviewDTO = missionCommandService.createMission(dto);

        return ApiResponse.onSuccess(missionPreviewDTO);
    }
    //4. 가게의 미션을 도전 중인 미션에 추가(미션 도전하기) API
    @PutMapping("")
    @Operation(method = "PATCH", summary = "도전 중인 미션 추가 API", description = "미션의 상태를 도전 중으로 수정하는 API입니다.")
    private ApiResponse<MissionResDTO.MissionPreviewDTO> updateMissionStatus(@Valid@RequestBody MissionReqDTO.ChallengingMissionDTO dto){
        MissionResDTO.MissionPreviewDTO missionPreviewDTO = missionCommandService.createChallengingMission(dto);
        return ApiResponse.onSuccess(missionPreviewDTO);
    }
}
