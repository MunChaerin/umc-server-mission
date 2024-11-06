package org.example.umcmission.service;

import org.example.umcmission.domain.Store;

import java.util.List;
import java.util.Optional;

public interface StoreQueryService {
    Optional<Store> findStore(Long var1);

    List<Store> findStoresByNameAndScore(String var1, Float var2);
}

