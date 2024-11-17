package org.example.umcmission.validation.annotaion;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.example.umcmission.validation.validator.MissionChallengingValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = MissionChallengingValidator.class)
@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface AlreadyChallenging {
    String message() default "이미 도전 중인 미션입니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
