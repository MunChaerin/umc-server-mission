package org.example.umcmission.service.ReviewService;

import org.example.umcmission.dto.responseDTO.ReviewResDTO;

public interface ReviewQueryService {
    ReviewResDTO.ReviewPreViewListDTO getReviews(Long memberId, int page, int size);
}
