package org.example.umcmission.validation.annotaion;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.example.umcmission.validation.validator.RegionsExistValidator;

import java.lang.annotation.*;

@Documented //사용자 정의 어노테이션을 만들 때
@Constraint(validatedBy = RegionsExistValidator.class) //커스텀 어노테이션을 통해 할 수 있도록 제공
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER }) //어노테이션의 적용 범위
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistRegions {
    String message() default "해당하는 지역이 존재하지 않습니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
