package org.example.umcmission.repository.StoreRepository;

import java.util.List;
import org.example.umcmission.domain.Store;

public interface StoreRepositoryCustom {
    List<Store> dynamicQueryWithBooleanBuilder(String name, Float score);
}
