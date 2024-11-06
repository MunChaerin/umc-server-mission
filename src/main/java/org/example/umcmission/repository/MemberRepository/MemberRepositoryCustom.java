package org.example.umcmission.repository.MemberRepository;

import org.example.umcmission.domain.Member;

public interface MemberRepositoryCustom {
    Member findMemberById(Long id);
}
