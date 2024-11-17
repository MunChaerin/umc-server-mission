package org.example.umcmission.repository;

import org.example.umcmission.domain.Region;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionRepository extends JpaRepository<Region, Long> {
    boolean existsById(Long id);
}
