package org.example.umcmission.repository.ReviewRepository;

public interface ReviewRepositoryCustom {
    void createReview(String title, Float score, Long memberId, Long storeId);
}
