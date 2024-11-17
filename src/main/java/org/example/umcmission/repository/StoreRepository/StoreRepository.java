package org.example.umcmission.repository.StoreRepository;

import org.example.umcmission.domain.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Long>, StoreRepositoryCustom {
    boolean existsById(Long id);
}
