package org.example.umcmission.validation.annotaion;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.example.umcmission.validation.validator.PageValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PageValidator.class)
@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckPage {
    String message() default "page는 1보다 크거나 같아야합니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
