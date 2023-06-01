package com.example.Buoi7_NguyenXuanToan.services;

import com.example.Buoi7_NguyenXuanToan.entity.phongban;
import com.example.Buoi7_NguyenXuanToan.repository.PhongBanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhongBanService {
    @Autowired
    private PhongBanRepository phongBanRepository;

    public List<phongban> getAllPhongBan(){
        return phongBanRepository.findAll();
    }

    public phongban getPhongBanById(String id){
        Optional<phongban> optionalPhongBan = phongBanRepository.findById(id);
        if (optionalPhongBan.isPresent()){
            return optionalPhongBan.get();
        } else {
            throw new RuntimeException("Không tìm thấy phòng ban");
        }

    }
    public phongban savePhongBan(phongban phongban)
    {
        return phongBanRepository.save(phongban);
    }
    public void deletePhongBan(String id){
        phongBanRepository.deleteById(id);
    }
}