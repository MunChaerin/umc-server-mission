package org.example.umcmission.repository.ReviewRepository;

import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.example.umcmission.domain.Member;
import org.example.umcmission.domain.QMember;
import org.example.umcmission.domain.QStore;
import org.example.umcmission.domain.Review;
import org.example.umcmission.domain.Store;
import org.springframework.stereotype.Repository;

@Repository
public class ReviewRepositoryImpl implements ReviewRepositoryCustom {
    private final EntityManager em;
    private final JPAQueryFactory jpaQueryFactory;

    public void createReview(String body, Float score, Long memberId, Long storeId) {
        QMember qMember = QMember.member;
        QStore qStore = QStore.store;
        Member member = (Member)((JPAQuery)this.jpaQueryFactory.selectFrom(qMember).where(qMember.id.eq(memberId))).fetchOne();
        Store store = (Store)((JPAQuery)this.jpaQueryFactory.selectFrom(qStore).where(qStore.id.eq(storeId))).fetchOne();
        Review review = Review.builder().body(body).score(score).member(member).store(store).build();
        this.em.persist(review);
    }

    public ReviewRepositoryImpl(EntityManager em, JPAQueryFactory jpaQueryFactory) {
        this.em = em;
        this.jpaQueryFactory = jpaQueryFactory;
    }
}

