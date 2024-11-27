package org.example.umcmission.converter;

import org.example.umcmission.domain.Member;
import org.example.umcmission.domain.enums.Gender;
import org.example.umcmission.dto.requestDTO.MemberRequestDTO;
import org.example.umcmission.dto.responseDTO.MemberResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class MemberConverter {
    //entity -> dto
    public static MemberResponseDTO.JoinResultDTO toJoinResultDTO(Member member){
        return MemberResponseDTO.JoinResultDTO.builder()
                .memberId(member.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    //dto -> entity
    public static Member toMember(MemberRequestDTO.JoinDto request) {
        Gender gender = null;
        switch (request.getGender()) {
            case 1: gender = Gender.MALE; break;
            case 2: gender = Gender.FEMALE; break;
            case 3: gender = Gender.NONE; break;
        }

        return Member.builder()
                .name(request.getName())
                .email(request.getEmail())   // 추가된 코드
                .password(request.getPassword())   // 추가된 코드
                .gender(gender)
                .address(request.getAddress())
                .specAddress(request.getSpecAddress())
                .role(request.getRole())   // 추가된 코드
                .memberPreferList(new ArrayList<>())
                .build();
    }
}
