package com.example.Buoi7_NguyenXuanToan.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "phongban")
public class phongban {
    @Id
    private String id;

    @Column(name = "TenPhong")
    private String name;

    @OneToMany(mappedBy = "phongban", cascade = CascadeType.ALL)
    private List<nhanvien> nhanviens;
}
