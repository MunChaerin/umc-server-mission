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
    public boolean isValid(Long missionId, ConstraintValidatorContext context) {
        if (missionId == null) {
            return true; // null인 경우를 허용 (필요에 따라 조정)
        }

        Mission mission = missionRepository.findById(missionId).orElse(null);

        if (mission == null) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("미션이 존재하지 않습니다.")
                    .addConstraintViolation();
            return false; // 미션이 존재하지 않으면 유효하지 않음
        }

        // 미션의 상태가 CHALLENGING인지 확인
        boolean isValid = mission.getMissionStatus() == MissionStatus.CHALLENGING;

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.MISSION_ALREADY_CHALLENGING.toString()).addConstraintViolation();
        }

        return isValid;
    }
}

