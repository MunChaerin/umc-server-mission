package org.example.umcmission.repository.ReviewRepository;

import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.example.umcmission.domain.*;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ReviewRepositoryImpl implements ReviewRepositoryCustom {
    private final EntityManager em;
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public void createReview(String title, Float score, Long memberId, Long storeId) {
        QMember qMember = QMember.member;
        QStore qStore = QStore.store;

        Member member = jpaQueryFactory
                .selectFrom(qMember)
                .where(qMember.id.eq(memberId))
                .fetchOne();

        Store store = jpaQueryFactory
                .selectFrom(qStore)
                .where(qStore.id.eq(storeId))
                .fetchOne();

        Review review = Review.builder()
                .title(title)
                .score(score)
                .member(member)
                .store(store)
                .build();

        em.persist(review);
    }
}

