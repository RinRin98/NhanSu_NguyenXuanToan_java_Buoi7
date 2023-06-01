package com.example.Buoi7_NguyenXuanToan.repository;

import com.example.Buoi7_NguyenXuanToan.entity.phongban;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhongBanRepository extends JpaRepository<phongban, String> {
}
