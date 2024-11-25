package org.example.umcmission.service.StoreService;

import org.example.umcmission.domain.Review;
import org.example.umcmission.domain.Store;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface StoreQueryService {

    Optional<Store> findStore(Long id);
    List<Store> findStoresByNameAndScore(String name, Float score);
    Page<Review> getReviewList(Long StoreId, Integer page);
}
