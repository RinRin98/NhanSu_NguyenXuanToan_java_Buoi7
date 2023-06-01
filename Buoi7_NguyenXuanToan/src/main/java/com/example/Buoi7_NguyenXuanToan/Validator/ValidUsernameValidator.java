package com.example.Buoi7_NguyenXuanToan.Validator;

import com.example.Buoi7_NguyenXuanToan.Validator.annotation.ValidUsername;
import com.example.Buoi7_NguyenXuanToan.repository.UserRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class ValidUsernameValidator implements ConstraintValidator<ValidUsername, String> {
    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean isValid(String username, ConstraintValidatorContext context){
        if (userRepository == null)
            return true;
        return userRepository.findByUsername(username) == null;
    }
}
