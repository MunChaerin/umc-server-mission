package org.example.umcmission.repository;

import org.example.umcmission.domain.Mission;
import org.example.umcmission.domain.enums.MissionStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissionRepository extends JpaRepository<Mission, Long> {
    // 특정 missionId와 status가 null인 미션이 존재하는지 확인
    boolean existsByIdAndMissionStatusIsNull(Long id);

    // 특정 missionId와 status가 CHALLENGING인 미션이 존재하는지 확인
    boolean existsByIdAndMissionStatus(Long id, MissionStatus status);
}
