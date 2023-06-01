package com.example.Buoi7_NguyenXuanToan.services;

import com.example.Buoi7_NguyenXuanToan.entity.nhanvien;
import com.example.Buoi7_NguyenXuanToan.repository.NhanVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NhanVienService {
    @Autowired
    private NhanVienRepository nhanVienRepository;
    public List<nhanvien> getAllNhanVien(){
        return nhanVienRepository.findAll();
    }

    public nhanvien getNhanVienById(String id){
        Optional<nhanvien> optional = nhanVienRepository.findById(id);
        return optional.orElse(null);
    }
    public void addNhanVien(nhanvien nhanvien){
        nhanVienRepository.save(nhanvien);
    }
    public void updateNhanVien(nhanvien nhanvien) {
        Optional<nhanvien> optional = nhanVienRepository.findById(nhanvien.getId());
        if (optional.isPresent()) {
            nhanvien existingNhanVien = optional.get();
            existingNhanVien.setHoten(nhanvien.getHoten());
            existingNhanVien.setPhai(nhanvien.getPhai());
            existingNhanVien.setNoisinh(nhanvien.getNoisinh());
            existingNhanVien.setLuong(nhanvien.getLuong());
            existingNhanVien.setPhongban(nhanvien.getPhongban());
            nhanVienRepository.save(existingNhanVien); // Lưu thay đổi vào cơ sở dữ liệu
        }
    }
    public void deleteNhanVien(String id){
        nhanVienRepository.deleteById(id);
    }
    public Page<nhanvien> searchNhanVien(String hoten, Pageable pageable) {
        if (hoten.isBlank()) {
            return nhanVienRepository.findAll(pageable); // Trả về tất cả nhân viên nếu không có tên được cung cấp
        }
        return nhanVienRepository.findByHotenContaining(hoten, pageable);
    }

    public Page<nhanvien> getListOfEmployees(Pageable pageable) {
        return nhanVienRepository.findAll(pageable);
    }

}
