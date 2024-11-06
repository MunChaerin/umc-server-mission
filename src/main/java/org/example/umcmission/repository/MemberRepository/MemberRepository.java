package org.example.umcmission.repository.MemberRepository;

import org.example.umcmission.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long>, MemberRepositoryCustom {
}
