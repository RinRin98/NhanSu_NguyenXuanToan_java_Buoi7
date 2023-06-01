package com.example.Buoi7_NguyenXuanToan.repository;

import com.example.Buoi7_NguyenXuanToan.entity.nhanvien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface NhanVienRepository extends JpaRepository<nhanvien, String> {
    List<nhanvien> findByhotenContaining(String hoten);
}
