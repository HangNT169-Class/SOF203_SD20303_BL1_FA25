package com.example.sof203_sd20303_bl1_fa25.B4_5_CRUDListFixCung.service;

import com.example.sof203_sd20303_bl1_fa25.B4_5_CRUDListFixCung.entity.SinhVien;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    public void removeSinhVien(String mssv){
        // C1: for lan luot tu dau toi cuoi (nhu cac mon truoc)
        // C2: removeIf trong lamda (Java 8 +)
//        for(SinhVien b: listSinhVien){
//        }
        listSinhVien.removeIf(b->b.getMssv1().equalsIgnoreCase(mssv));
    }

    public List<SinhVien>searchSinhVien(String name){
        // filter trong Java 8
        return listSinhVien.stream()
                .filter(sv -> sv.getTen().contains(name))
                .collect(Collectors.toList());
//        for(SinhVien sv: listSinhVien){
//            if(sv.getMssv1().equalsIgnoreCase(mssv)){
//                // add vao list
//            }
//        }
    }

    public SinhVien detailSinhVien(String mssv){
        return listSinhVien.stream()
                .filter(sv->sv.getMssv1().equalsIgnoreCase(mssv))
                .findFirst().orElse(null);
    }
    public void addSinhVien(SinhVien sv){
        listSinhVien.add(sv);
    }

}
