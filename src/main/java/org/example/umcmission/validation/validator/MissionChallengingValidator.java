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

import java.util.Optional;

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
            return true; // null인 경우를 허용
        }
        // 미션을 찾고, 없을 경우 null 체크
        Optional<Mission> optionalMission = missionRepository.findById(id);
        if (!optionalMission.isPresent()) {
            return true; // 미션이 없으면 허용
        }

        Mission mission = optionalMission.get();

        // 미션 상태가 null인 경우, 검증을 하지 않고 통과
        if (mission.getMissionStatus() == null) {
            return true; // 상태가 null인 경우 허용
        }

        // 미션 상태가 CHALLENGING일 경우 유효하지 않음
        if (mission.getMissionStatus() == MissionStatus.CHALLENGING) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.MISSION_ALREADY_CHALLENGING.toString())
                    .addConstraintViolation(); // 유효하지 않음
            return false; // 유효하지 않은 경우
        }

        return true; // 유효한 경우
    }

}
