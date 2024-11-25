package org.example.umcmission.service.ReviewService;

import lombok.RequiredArgsConstructor;
import org.example.umcmission.converter.ReviewConverter;
import org.example.umcmission.domain.Review;
import org.example.umcmission.dto.responseDTO.ReviewResDTO;
import org.example.umcmission.repository.ReviewRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ReviewQueryServiceImpl implements ReviewQueryService{
    private final ReviewRepository reviewRepository;

    @Override
    @Transactional(readOnly = true)
    public ReviewResDTO.ReviewPreViewListDTO getReviews(Long memberId, int page, int size){
        int validpage = Math.max(page - 1, 0);
        Page<Review> reviews = reviewRepository.findByMemberId(memberId, PageRequest.of(validpage, size));
        return ReviewConverter.toReviewPreviewListDTO(reviews);
    }

}
