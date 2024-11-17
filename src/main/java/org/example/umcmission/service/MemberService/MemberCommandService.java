package org.example.umcmission.service.MemberService;

import org.example.umcmission.domain.Member;
import org.example.umcmission.dto.requestDTO.MemberRequestDTO;

public interface MemberCommandService {
    Member joinMember(MemberRequestDTO.JoinDto request);
}
