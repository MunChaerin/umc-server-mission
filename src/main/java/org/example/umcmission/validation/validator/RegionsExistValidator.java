package org.example.umcmission.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.example.umcmission.apiPayload.code.status.ErrorStatus;
import org.example.umcmission.repository.RegionRepository;
import org.example.umcmission.service.StoreService.StoreCommandService;
import org.example.umcmission.validation.annotaion.ExistCategories;
import org.example.umcmission.validation.annotaion.ExistRegions;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class RegionsExistValidator implements ConstraintValidator<ExistRegions, List<Long>> {
    private final RegionRepository regionRepository;

    @Override
    public void initialize(ExistRegions constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(List<Long> values, ConstraintValidatorContext context) {
        boolean isValid = values.stream()
                .allMatch(value -> regionRepository.existsById(value));

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.REGION_NOT_FOUND.toString()).addConstraintViolation();
        }

        return isValid;

    }
}
