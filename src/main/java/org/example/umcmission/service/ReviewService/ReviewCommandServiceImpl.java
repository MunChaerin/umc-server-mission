package org.example.umcmission.service.ReviewService;

import lombok.RequiredArgsConstructor;
import org.example.umcmission.apiPayload.code.status.ErrorStatus;
import org.example.umcmission.apiPayload.exception.handler.MemberHandler;
import org.example.umcmission.apiPayload.exception.handler.StoreHandler;
import org.example.umcmission.converter.ReviewConverter;
import org.example.umcmission.domain.Member;
import org.example.umcmission.domain.Review;
import org.example.umcmission.domain.Store;
import org.example.umcmission.dto.requestDTO.ReviewReqDTO;
import org.example.umcmission.dto.responseDTO.ReviewResDTO;
import org.example.umcmission.repository.MemberRepository;
import org.example.umcmission.repository.ReviewRepository;
import org.example.umcmission.repository.StoreRepository.StoreRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService{
    private final StoreRepository storeRepository;
    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;

    @Override
    public ReviewResDTO.ReviewPreviewDTO createReview(ReviewReqDTO.CreateReviewReqDTO dto){
        Store store = storeRepository.findById(dto.getStoreId())
                .orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND));
        Member member = memberRepository.findById(dto.getMemberId()).orElseThrow(() -> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));
        Review review = reviewRepository.save(ReviewConverter.toReview(dto,store, member));
        return ReviewConverter.toReviewDTO(review);
    }
}
