package org.example.umcmission.repository.MemberRepository;

import org.example.umcmission.domain.Member;

import java.util.Optional;

public interface MemberRepositoryCustom {
    Optional<Member> findById(Long var1);
}
