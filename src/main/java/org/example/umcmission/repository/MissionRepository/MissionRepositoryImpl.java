package org.example.umcmission.repository.MissionRepository;

import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;

import lombok.RequiredArgsConstructor;
import org.example.umcmission.domain.Mission;
import org.example.umcmission.domain.QMission;
import org.example.umcmission.domain.QRegion;
import org.example.umcmission.domain.QStore;
import org.example.umcmission.domain.enums.MissionStatus;
import org.example.umcmission.domain.mapping.QMemberMission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import static com.querydsl.core.QueryModifiers.offset;

@Repository
@RequiredArgsConstructor
public class MissionRepositoryImpl implements MissionRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;
    private final QMission mission = QMission.mission;
    private final QStore store = QStore.store;

    @Override
    public Page<Mission> findByStatus(MissionStatus status, Pageable pageable) {
        List<Mission> missions = jpaQueryFactory
                .selectFrom(mission)
                .where(mission.status.eq(status))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(mission.id.asc())
                .fetch();

        long total = jpaQueryFactory
                .selectFrom(mission)
                .where(mission.status.eq(status))
                .fetchCount();

        return new PageImpl<>(missions, pageable, total);
    }

    @Override
    public Page<Mission> findByRegion(Long regionId, Pageable pageable) {
        List<Mission> missions = jpaQueryFactory
                .selectFrom(mission)
                .join(mission.store, store)
                .where(mission.status.eq(MissionStatus.READY)
                        .and(store.region.id.eq(regionId)))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(mission.deadline.asc())
                .fetch();

        long total = jpaQueryFactory
                .selectFrom(mission)
                .join(mission.store, store)
                .where(mission.status.eq(MissionStatus.READY)
                        .and(store.region.id.eq(regionId)))
                .fetchCount();

        return new PageImpl<>(missions, pageable, total);
    }
}

