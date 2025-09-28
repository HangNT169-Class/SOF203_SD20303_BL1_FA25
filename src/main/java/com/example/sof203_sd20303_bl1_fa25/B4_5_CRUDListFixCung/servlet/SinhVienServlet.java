package com.example.sof203_sd20303_bl1_fa25.B4_5_CRUDListFixCung.servlet;

import com.example.sof203_sd20303_bl1_fa25.B4_5_CRUDListFixCung.entity.SinhVien;
import com.example.sof203_sd20303_bl1_fa25.B4_5_CRUDListFixCung.service.SinhVienService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;

@WebServlet(name = "SinhVienServlet", value = {
        "/sinh-vien/hien-thi", // GET
        "/sinh-vien/search", // GET
        "/sinh-vien/remove", // GET
        "/sinh-vien/update", // POST
        "/sinh-vien/add", // POST: nhap lieu sau do bam button submit
        "/sinh-vien/view-add",// GET: Hien thi ra form add
        "/sinh-vien/view-update", // GET
        // GET: hien thi, lay ra...
        // Post: xu ly form, thong tin che giau di (an thong tin trong form di)
})
public class SinhVienServlet extends HttpServlet {
    // Goi service
    private SinhVienService svService = new SinhVienService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 6 duong dan vao do get
        // http://localhost:8080/sinh-vien/remove => url
        // http/https: server:port:path(co the co) + uri
        String uri = request.getRequestURI();
//        System.out.println(uri);
        // C1: switch case
//        switch (uri){
//            case "/sinh-vien/hien-thi":{
//                break;
//            }
//        }
        // C2: if..else
        if(uri.contains("hien-thi")){
            // hien thi du lieu form
            this.hienThiDuLieu(request,response);
        }else if(uri.contains("remove")){
            // remove
            this.remove(request,response);
        }else if(uri.contains("search")){
            // search
            this.search(request,response);
        }else if(uri.contains("view-update")){
            // view-update
            this.viewUpdate(request,response);
        }else{
            // view - add
            this.viewAdd(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("add")){
            this.add(request,response);
        }else{
            // update
            this.update(request,response);
        }
    }

    private void viewAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/buoi3/add-sinh-vien.jsp").forward(request,response);
    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String mssv = request.getParameter("mssv");
        SinhVien sv = svService.detailSinhVien(mssv);
        request.setAttribute("sv1",sv);
        request.getRequestDispatcher("/buoi3/update-sinh-vien.jsp").forward(request,response);
    }

    private void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("ten");
        request.setAttribute("list1",svService.searchSinhVien(name));
        request.getRequestDispatcher("/buoi3/sinhviens.jsp").forward(request,response);
    }

    private void remove(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // B1: Lay gia tri cua mssv tren duong dan (giao dien)
        String mssv = request.getParameter("a1");
        // B2: Goi ham remove trong service
        svService.removeSinhVien(mssv);
        // B3: Quay lai trang hien thi
        response.sendRedirect("/sinh-vien/hien-thi");
    }

    private void hienThiDuLieu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("list1",svService.getListSinhVien());
        request.getRequestDispatcher("/buoi3/sinhviens.jsp").forward(request,response);
    }

    private void update(HttpServletRequest request, HttpServletResponse response) {
    }

    @SneakyThrows
    private void add(HttpServletRequest request, HttpServletResponse response) {
        // B1: Tao 1 doi tuong moi
        SinhVien sv = new SinhVien();
        // B2: Su beanutil => TU DONG MAP TOAN BO CAC THUOC TINH CUA O INPUT
        // VAO DOI TUONG SINH VIEN
        // LUU Y: KHI DUNG BEANUTIL => NAME TRONG INPUT TRUNG VS TEN TRONG ENTIY
        BeanUtils.populate(sv,request.getParameterMap());
        // B3: Goi ham add trong service
        svService.addSinhVien(sv);
        //B4: Chuyen trang
        response.sendRedirect("/sinh-vien/hien-thi");
    }
}
