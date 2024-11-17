package org.example.umcmission.validation.annotaion;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.example.umcmission.validation.validator.MissionChallengingValidator;

import java.lang.annotation.*;

@Constraint(validatedBy = MissionChallengingValidator.class)
@Target({ ElementType.PARAMETER, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface AlreadyChallenging {
    String message() default "미션이 이미 도전 중입니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
