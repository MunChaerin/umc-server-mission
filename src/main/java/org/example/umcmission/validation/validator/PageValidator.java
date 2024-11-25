package org.example.umcmission.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.example.umcmission.validation.annotaion.CheckPage;

public class PageValidator implements ConstraintValidator<CheckPage, Integer> {
    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        if (value == null || value < 1) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Page는 1보다 크거나 같아야합니다.")
                    .addConstraintViolation();
            return false;
        }
        return true;
    }
}
