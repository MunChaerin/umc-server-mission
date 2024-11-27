package org.example.umcmission.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.umcmission.apiPayload.ApiResponse;
import org.example.umcmission.dto.requestDTO.MissionReqDTO;
import org.example.umcmission.dto.responseDTO.MemberMissionResDTO;
import org.example.umcmission.dto.responseDTO.MissionResDTO;
import org.example.umcmission.service.MissionService.MemberMissionCommandService;
import org.example.umcmission.service.MissionService.MemberMissionQueryService;
import org.example.umcmission.service.MissionService.MissionCommandService;
import org.example.umcmission.service.MissionService.MissionQueryService;
import org.example.umcmission.validation.annotaion.CheckPage;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
@Tag(name = "미션 관련 API")
@Validated
public class MissionController {
    private final MissionCommandService missionCommandService;
    private final MissionQueryService missionQueryService;
    private final MemberMissionQueryService memberMissionQueryService;
    private final MemberMissionCommandService memberMissionCommandService;

    @PostMapping("")
    @Operation(method = "POST", summary = "미션 추가 API", description = "해당 가게에 미션을 추가하는 API입니다.")
    public ApiResponse<MissionResDTO.MissionPreviewDTO> createMission(@Valid@RequestBody MissionReqDTO.CreateMissionDTO dto){
        MissionResDTO.MissionPreviewDTO missionPreviewDTO = missionCommandService.createMission(dto);

        return ApiResponse.onSuccess(missionPreviewDTO);
    }
    @PostMapping("/challenging")
    @Operation(method = "POST", summary = "도전 중인 미션 추가 API", description = "미션의 상태를 도전 중으로 수정하는 API입니다.")
    public ApiResponse<MissionResDTO.MissionPreviewDTO> updateMissionStatus(@Valid@RequestBody MissionReqDTO.ChallengingMissionDTO dto){
        MissionResDTO.MissionPreviewDTO missionPreviewDTO = missionCommandService.createChallengingMission(dto);
        return ApiResponse.onSuccess(missionPreviewDTO);
    }

    @GetMapping("/{storeId}")
    @Operation(method = "GET", summary = "특정 가게 미션 조회 API", description = "특정 가게의 미션을 조회하는 API입니다.")
    public ApiResponse<MissionResDTO.MissionPreViewListDTO> getMissions(
            @PathVariable Long storeId,
            @CheckPage@RequestParam int page,
            @CheckPage@RequestParam int size
    ){
        MissionResDTO.MissionPreViewListDTO missionPreViewListDTO = missionQueryService.getMissions(storeId,page,size);
        return ApiResponse.onSuccess(missionPreViewListDTO);
    }

    @GetMapping("/members/{memberId}")
    @Operation(method = "GET", summary = "내가 진행 중인 미션 조회 API", description = "특정 유저가 진행 중인 미션을 조회하는 API입니다.")
    public ApiResponse<MemberMissionResDTO.MemberMissionListDTO> getChallengingMissions(
            @PathVariable Long memberId,
            @CheckPage@RequestParam int page,
            @CheckPage@RequestParam int size
    ){
        MemberMissionResDTO.MemberMissionListDTO memberMissionListDTO = memberMissionQueryService.getChallengingMissions(memberId, page-1,size);
        return ApiResponse.onSuccess(memberMissionListDTO);
    }

    @PatchMapping("/members/{memberMissionId}/complete")
    @Operation(method = "PATCH", summary = "진행 중인 미션 완료 처리 API", description = "특정 유저가 진행 중인 미션을 완료로 수정하는 API입니다.")
    public ApiResponse<String> completeMission(@PathVariable Long memberMissionId){
        memberMissionCommandService.completeMission(memberMissionId);
        return ApiResponse.onSuccess("성공적으로 변경되었습니다.");
    }
}
