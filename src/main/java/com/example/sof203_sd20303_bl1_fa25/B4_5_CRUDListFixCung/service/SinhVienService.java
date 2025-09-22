package com.example.sof203_sd20303_bl1_fa25.B4_5_CRUDListFixCung.service;

import com.example.sof203_sd20303_bl1_fa25.B4_5_CRUDListFixCung.entity.SinhVien;

import java.util.ArrayList;
import java.util.List;

public class SinhVienService {

    private List<SinhVien> listSinhVien = new ArrayList<>();

    public SinhVienService() {
        // fake data
        listSinhVien.add(new SinhVien("SV01", "Nguyen Van A", 10, "Ha noi", true));
        listSinhVien.add(new SinhVien("SV02", "Nguyen Van B", 11, "Ha noi1", false));
        listSinhVien.add(new SinhVien("SV03", "Nguyen Van C", 12, "Ha noi", false));
        listSinhVien.add(new SinhVien("SV04", "Nguyen Van D", 13, "Ha noi3", true));
        listSinhVien.add(new SinhVien("SV05", "Nguyen Van E", 17, "Ha noi9", false));
    }

    public List<SinhVien> getListSinhVien() {
        return listSinhVien;
    }
}
