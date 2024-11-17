package org.example.umcmission.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.umcmission.apiPayload.ApiResponse;
import org.example.umcmission.converter.MemberConverter;
import org.example.umcmission.domain.Member;
import org.example.umcmission.dto.requestDTO.MemberRequestDTO;
import org.example.umcmission.dto.responseDTO.MemberResponseDTO;
import org.example.umcmission.service.MemberService.MemberCommandService;
import org.example.umcmission.validation.annotaion.ExistCategories;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberRestController {

    private final MemberCommandService memberCommandService;

    @PostMapping("/signup")
    public ApiResponse<MemberResponseDTO.JoinResultDTO> join(@RequestBody @ExistCategories MemberRequestDTO.JoinDto request){
        Member member = memberCommandService.joinMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
    }
}
