package org.example.umcmission.validation.annotaion;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.example.umcmission.validation.validator.CategoriesExistValidator;

import java.lang.annotation.*;

@Documented //사용자 정의 어노테이션을 만들 때
@Constraint(validatedBy = CategoriesExistValidator.class) //커스텀 어노테이션을 통해 할 수 있도록 제공
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER }) //어노테이션의 적용 범위
@Retention(RetentionPolicy.RUNTIME) //생명 주기를 지정, 위의 코드는 RUNTIME이기에 실행 하는 동안에만 유효
public @interface ExistCategories {

    String message() default "해당하는 카테고리가 존재하지 않습니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
