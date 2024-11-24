package org.example.umcmission.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.example.umcmission.domain.enums.MissionStatus;
import org.example.umcmission.repository.MemberMissionRespository;
import org.example.umcmission.repository.MissionRepository;
import org.example.umcmission.validation.annotaion.AlreadyChallenging;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MissionChallengingValidator implements ConstraintValidator<AlreadyChallenging, Long> {
    private final MemberMissionRespository memberMissionRespository;
    private final MissionRepository missionRepository;

    @Override
    public boolean isValid(Long missionId, ConstraintValidatorContext context) {
        Long memberId=1L; //하드코딩
        //해당 미션이 존재하는지
        boolean missionExists = missionRepository.existsById(missionId);
        if (!missionExists) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("해당 미션이 존재하지 않습니다.")
                    .addConstraintViolation();
            return false;
        }
        //해당 미션이 진행중인지
        boolean isInProgress = memberMissionRespository.existsByMemberIdAndMissionIdAndStatus(memberId, missionId, MissionStatus.CHALLENGING);

        if (isInProgress) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("해당 미션은 이미 진행 중입니다.")
                    .addConstraintViolation();
            return false;
        }

        return true;
    }
}
