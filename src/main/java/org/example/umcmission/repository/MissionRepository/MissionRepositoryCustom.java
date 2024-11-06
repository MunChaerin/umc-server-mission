package org.example.umcmission.repository.MissionRepository;

import org.example.umcmission.domain.Mission;
import org.example.umcmission.domain.enums.MissionStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MissionRepositoryCustom {
    Page<Mission> findByStatus(MissionStatus status, Pageable pageable);
    Page<Mission> findByRegion(Long regionId, Pageable pageable);
}
