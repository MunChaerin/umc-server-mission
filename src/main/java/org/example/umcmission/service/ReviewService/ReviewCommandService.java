package org.example.umcmission.service.ReviewService;

import org.example.umcmission.domain.Member;
import org.example.umcmission.domain.Store;
import org.example.umcmission.dto.requestDTO.ReviewReqDTO;
import org.example.umcmission.dto.responseDTO.ReviewResDTO;

public interface ReviewCommandService {
    ReviewResDTO.ReviewPreviewDTO createReview(ReviewReqDTO.CreateReviewReqDTO dto);
}
