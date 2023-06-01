package com.example.Buoi7_NguyenXuanToan.services;

import com.example.Buoi7_NguyenXuanToan.entity.User;
import com.example.Buoi7_NguyenXuanToan.repository.RoleRepository;
import com.example.Buoi7_NguyenXuanToan.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;
    public void save (User user){
        userRepository.save(user);
        Long userId = userRepository.getUserIdByUserName(user.getUsername());
        Long roleId = roleRepository.getRoleIdByName("USER");
        if (roleId != 0 && userId != 0){
            userRepository.addRoleToUser(userId, roleId);
        }
    }
}