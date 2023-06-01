package com.example.Buoi7_NguyenXuanToan.controller;

import com.example.Buoi7_NguyenXuanToan.entity.nhanvien;
import com.example.Buoi7_NguyenXuanToan.services.NhanVienService;
import com.example.Buoi7_NguyenXuanToan.services.PhongBanService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@Controller
@RequestMapping("/nhanviens")
public class NhanVienController {
    @Autowired
    private NhanVienService nhanVienService;
    @Autowired
    public PhongBanService phongBanService;
    @GetMapping
    public String showAllNhanVien(Model model,  @RequestParam(defaultValue = "0") int page){
        int pageSize = 5; // Số lượng nhân viên trên mỗi trang
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<nhanvien> employeePage = nhanVienService.getListOfEmployees(pageable);
        List<nhanvien> nhanviens = nhanVienService.getAllNhanVien();
        model.addAttribute("nhanviens", nhanviens);
        model.addAttribute("nhanviens", employeePage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", employeePage.getTotalPages());
        return "nhanvien/list";
    }


    @GetMapping("/add")
    public String addNhanVien(Model model){
        model.addAttribute("nhanvien", new nhanvien());
        model.addAttribute("phongbans", phongBanService.getAllPhongBan());
        return "nhanvien/add";
    }

    @PostMapping("/add")
    public String addNhanVien(@ModelAttribute("nhanvien") @Valid nhanvien nhanvien, BindingResult result, Model model) {
        // Kiểm tra ràng buộc và đặt thông báo lỗi vào BindingResult
        if (result.hasErrors()) {

            model.addAttribute("phongbans", phongBanService.getAllPhongBan());
            return "nhanvien/add";
        } else {
            // Nếu không có lỗi, thêm sách và chuyển hướng đến trang danh sách sách
            nhanVienService.addNhanVien(nhanvien);
            return "redirect:/nhanviens";
        }
    }
    @GetMapping("/edit/{id}")
    public String editNhanVien(@PathVariable("id") String id, Model model) {
        nhanvien editnhanvien = nhanVienService.getNhanVienById(id);
        if (editnhanvien != null) {
            model.addAttribute("nhanvien", editnhanvien);
            model.addAttribute("phongbans", phongBanService.getAllPhongBan());
            return "nhanvien/edit";
        } else {
            return "redirect:/nhanviens";
        }
    }

    @PostMapping("/edit/{id}")
    public String editNhanVien(@PathVariable("id") String id, @ModelAttribute("nhanvien") @Valid  nhanvien editNhanVien, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("phongbans", phongBanService.getAllPhongBan());
            return "nhanvien/edit";
        } else {
            nhanvien existingNhanVien = nhanVienService.getNhanVienById(id);
            if (existingNhanVien != null) {
                existingNhanVien.setHoten(editNhanVien.getHoten());
                existingNhanVien.setPhai(editNhanVien.getPhai());
                existingNhanVien.setNoisinh(editNhanVien.getNoisinh());
                existingNhanVien.setLuong(editNhanVien.getLuong());
                existingNhanVien.setPhongban(editNhanVien.getPhongban());
                nhanVienService.updateNhanVien(existingNhanVien); // Lưu thay đổi vào cơ sở dữ liệu
            }
            return "redirect:/nhanviens";
        }
    }





    @GetMapping("/delete/{id}")
    public String deleteNhanVien(@PathVariable("id") String id) {
        nhanVienService.deleteNhanVien(id);
        return "redirect:/nhanviens";
    }

    @GetMapping("/search")
    public String searchNhanVien(@RequestParam("input") String input, @RequestParam(defaultValue = "0") int page, Model model) {
        int pageSize = 5; // Số lượng nhân viên trên mỗi trang
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<nhanvien> searchResultsPage = nhanVienService.searchNhanVien(input, pageable);

        model.addAttribute("nhanviens", searchResultsPage.getContent());
        model.addAttribute("hoten", "nhanvien " + input);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", searchResultsPage.getTotalPages());

        return "nhanvien/list";
    }




}
