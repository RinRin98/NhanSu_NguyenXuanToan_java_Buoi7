package com.example.Buoi7_NguyenXuanToan.Validator;

import com.example.Buoi7_NguyenXuanToan.Validator.annotation.ValidUserId;
import com.example.Buoi7_NguyenXuanToan.entity.User;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidUserIdValidator implements ConstraintValidator<ValidUserId, User> {
    @Override
    public  boolean isValid(User user, ConstraintValidatorContext context)
    {
        if (user == null)
            return true;
        return user.getId() != null;
    }
}
