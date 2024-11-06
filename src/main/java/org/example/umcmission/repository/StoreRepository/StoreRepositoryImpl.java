package org.example.umcmission.repository.StoreRepository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import org.example.umcmission.domain.QStore;
import org.example.umcmission.domain.Store;
import org.springframework.stereotype.Repository;

@Repository
public class StoreRepositoryImpl implements StoreRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;
    private final QStore store;

    public List<Store> dynamicQueryWithBooleanBuilder(String name, Float score) {
        BooleanBuilder predicate = new BooleanBuilder();
        if (name != null) {
            predicate.and(this.store.name.eq(name));
        }

        if (score != null) {
            predicate.and(this.store.score.goe(4.0F));
        }

        return ((JPAQuery)this.jpaQueryFactory.selectFrom(this.store).where(predicate)).fetch();
    }

    public StoreRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        this.store = QStore.store;
        this.jpaQueryFactory = jpaQueryFactory;
    }
}

