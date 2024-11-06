package org.example.umcmission.repository.MemberRepository;

import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.example.umcmission.domain.Member;
import org.example.umcmission.domain.QMember;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class MemberRepositoryImpl implements MemberRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;
    private final QMember member;

    public Optional<Member> findById(Long id) {
        return Optional.ofNullable((Member)((JPAQuery)this.jpaQueryFactory.selectFrom(this.member).where(this.member.id.eq(id))).fetchOne());
    }

    public MemberRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        this.member = QMember.member;
        this.jpaQueryFactory = jpaQueryFactory;
    }
}

