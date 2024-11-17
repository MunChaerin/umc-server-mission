package org.example.umcmission.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.example.umcmission.apiPayload.code.status.ErrorStatus;
import org.example.umcmission.domain.Mission;
import org.example.umcmission.domain.enums.MissionStatus;
import org.example.umcmission.repository.MissionRepository;
import org.example.umcmission.validation.annotaion.AlreadyChallenging;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MissionChallengingValidator implements ConstraintValidator<AlreadyChallenging, Long> {
    private final MissionRepository missionRepository;
    @Override
    public void initialize(AlreadyChallenging constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long id, ConstraintValidatorContext context) {
        if (id == null) {
            return true; // null인 경우를 허용 (필요에 따라 조정)
        }

        Mission mission = missionRepository.findById(id).orElse(null);

        if(mission.getMissionStatus() == null){
            return true;
        }

        // 미션 상태를 검증하는 로직 구현
        if (mission.getMissionStatus() == MissionStatus.CHALLENGING) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.MISSION_ALREADY_CHALLENGING.toString()).addConstraintViolation(); // 유효하지 않음
            return false;
        }

        return true; // 유효한 경우
    }
}
