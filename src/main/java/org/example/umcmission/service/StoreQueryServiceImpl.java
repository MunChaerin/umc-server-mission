package org.example.umcmission.service;

import org.example.umcmission.domain.Store;
import org.example.umcmission.repository.StoreRepository.StoreRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(
        readOnly = true
)
public class StoreQueryServiceImpl implements StoreQueryService {
    private final StoreRepository storeRepository;

    public Optional<Store> findStore(Long id) {
        return this.storeRepository.findById(id);
    }

    public List<Store> findStoresByNameAndScore(String name, Float score) {
        List<Store> filteredStores = this.storeRepository.dynamicQueryWithBooleanBuilder(name, score);
        filteredStores.forEach((store) -> {
            System.out.println("Store: " + store);
        });
        return filteredStores;
    }

    public StoreQueryServiceImpl(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }
}

