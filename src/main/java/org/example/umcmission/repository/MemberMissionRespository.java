package org.example.umcmission.repository;

import org.example.umcmission.domain.enums.MissionStatus;
import org.example.umcmission.domain.mapping.MemberMission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberMissionRespository extends JpaRepository<MemberMission, Long> {
    boolean existsByMemberIdAndMissionIdAndStatus(Long memberId, Long missionId, MissionStatus status);
}
