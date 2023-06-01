package com.example.Buoi7_NguyenXuanToan.repository;

import com.example.Buoi7_NguyenXuanToan.entity.nhanvien;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NhanVienRepository extends JpaRepository<nhanvien, String> {
    Page<nhanvien> findByHotenContaining(String hoten, Pageable pageable);
}