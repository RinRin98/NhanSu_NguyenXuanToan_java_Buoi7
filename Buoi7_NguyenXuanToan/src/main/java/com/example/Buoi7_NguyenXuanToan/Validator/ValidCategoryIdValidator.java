package com.example.Buoi7_NguyenXuanToan.Validator;

import com.example.Buoi7_NguyenXuanToan.Validator.annotation.ValidPhongBanId;
import com.example.Buoi7_NguyenXuanToan.entity.phongban;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidCategoryIdValidator implements ConstraintValidator<ValidPhongBanId, phongban> {
    @Override
    public boolean isValid(phongban category, ConstraintValidatorContext context){
        return category != null && category.getId() != null;
    }
}
