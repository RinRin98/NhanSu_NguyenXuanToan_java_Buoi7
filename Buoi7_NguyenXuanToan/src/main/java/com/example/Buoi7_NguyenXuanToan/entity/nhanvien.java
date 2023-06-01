package com.example.Buoi7_NguyenXuanToan.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

@Data
@Entity
@Table(name="nhanvien")
@AllArgsConstructor
@NoArgsConstructor
public class nhanvien {
    @Id
    private String id;

    @Column(name = "hoten")
    private String hoten;

    @Column(name = "phai", length = 50)
    private String phai;

    @Column(name = "noisinh", length = 150)
    private String noisinh;

    @Column(name = "Luong")
    private Double luong;

    @ManyToOne
    @JoinColumn(name = "phongban_id", referencedColumnName = "id")
    private phongban phongban;

    @ManyToOne
    @JoinColumn(name="user_id", referencedColumnName = "id")
    private User user;
}
