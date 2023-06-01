package com.example.Buoi7_NguyenXuanToan.Validator.annotation;

import com.example.Buoi7_NguyenXuanToan.Validator.ValidCategoryIdValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint( validatedBy = ValidCategoryIdValidator.class)
@Documented
public @interface ValidPhongBanId {
    String message() default "Invalid Phong Ban Id";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
