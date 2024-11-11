package org.example.umcmission.service.MemberService;

import org.example.umcmission.domain.Member;

import java.util.Optional;

public interface MemberQueryService {

    Optional<Member> findMember(Long id);

}
