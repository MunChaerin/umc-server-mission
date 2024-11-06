package org.example.umcmission.repository.MissionRepository;

import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import org.example.umcmission.domain.Mission;
import org.example.umcmission.domain.QMission;
import org.example.umcmission.domain.QRegion;
import org.example.umcmission.domain.QStore;
import org.example.umcmission.domain.enums.MissionStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public class MissionRepositoryImpl implements MissionRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;
    private final QMission mission;
    private final QRegion region;

    public Page<Mission> findByStatus(MissionStatus status, Pageable pageable) {
        List<Mission> missionList = ((JPAQuery)((JPAQuery)((JPAQuery)((JPAQuery)this.jpaQueryFactory.selectFrom(this.mission).where(this.mission.status.eq(status))).offset(pageable.getOffset())).limit((long)pageable.getPageSize())).orderBy(this.mission.id.asc())).fetch();
        long total = ((JPAQuery)this.jpaQueryFactory.selectFrom(this.mission).where(this.mission.status.eq(status))).fetchCount();
        return new PageImpl(missionList, pageable, total);
    }

    public Page<Mission> findByRegion(Long regionId, Pageable pageable) {
        List<Mission> missions = ((JPAQuery)((JPAQuery)((JPAQuery)((JPAQuery)((JPAQuery)this.jpaQueryFactory.selectFrom(this.mission).join(this.mission.store, QStore.store)).where(this.mission.status.eq(MissionStatus.CHALLENGING).and(QStore.store.region.id.eq(regionId)))).offset(pageable.getOffset())).limit((long)pageable.getPageSize())).orderBy(this.mission.deadline.asc())).fetch();
        long total = ((JPAQuery)((JPAQuery)this.jpaQueryFactory.selectFrom(this.mission).join(this.mission.store, QStore.store)).where(this.mission.status.eq(MissionStatus.CHALLENGING).and(QStore.store.region.id.eq(regionId)))).fetchCount();
        return new PageImpl(missions, pageable, total);
    }

    public MissionRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        this.mission = QMission.mission;
        this.region = QRegion.region;
        this.jpaQueryFactory = jpaQueryFactory;
    }
}

