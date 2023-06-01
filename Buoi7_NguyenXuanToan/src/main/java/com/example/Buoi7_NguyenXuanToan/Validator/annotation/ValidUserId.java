package com.example.Buoi7_NguyenXuanToan.Validator.annotation;

import com.example.Buoi7_NguyenXuanToan.Validator.ValidUserIdValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidUserIdValidator.class)
@Documented
public @interface ValidUserId {
    String message() default "Invalid User Id";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
