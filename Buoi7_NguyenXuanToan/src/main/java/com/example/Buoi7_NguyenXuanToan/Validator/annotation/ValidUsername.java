package com.example.Buoi7_NguyenXuanToan.Validator.annotation;


import com.example.Buoi7_NguyenXuanToan.Validator.ValidUsernameValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidUsernameValidator.class)
public @interface ValidUsername {
    String message() default "UserName already exists";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
