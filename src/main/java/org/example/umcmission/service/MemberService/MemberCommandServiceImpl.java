package org.example.umcmission.service.MemberService;

import lombok.RequiredArgsConstructor;
import org.example.umcmission.apiPayload.code.status.ErrorStatus;
import org.example.umcmission.apiPayload.exception.handler.FoodCategoryHandler;
import org.example.umcmission.converter.MemberConverter;
import org.example.umcmission.converter.MemberPreferConverter;
import org.example.umcmission.domain.FoodCategory;
import org.example.umcmission.domain.Member;
import org.example.umcmission.domain.mapping.MemberPrefer;
import org.example.umcmission.dto.requestDTO.MemberRequestDTO;
import org.example.umcmission.repository.FoodCategoryRepository;
import org.example.umcmission.repository.MemberRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService{

    private final MemberRepository memberRepository;
    private final FoodCategoryRepository foodCategoryRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public Member joinMember(MemberRequestDTO.JoinDto request) {

        Member newMember = MemberConverter.toMember(request);

        newMember.encodePassword(passwordEncoder.encode(request.getPassword()));

        List<FoodCategory> foodCategoryList = request.getPreferCategory().stream()
                .map(categoryId -> foodCategoryRepository.findById(categoryId)
                        .orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND)))
                .collect(Collectors.toList());

        List<MemberPrefer> memberPreferList = MemberPreferConverter.toMemberPreferList(foodCategoryList);

        memberPreferList.forEach(memberPrefer -> {
            memberPrefer.setMember(newMember);
            newMember.getMemberPreferList().add(memberPrefer);
        });

        Member savedMember = memberRepository.save(newMember);
        System.out.println("Saved Member: " + savedMember);

        return savedMember;
    }
}
