package com.example.sof203_sd20303_bl1_fa25.B4_5_CRUDListFixCung.servlet;

import com.example.sof203_sd20303_bl1_fa25.B4_5_CRUDListFixCung.service.SinhVienService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "SinhVienServlet", value = {
        "/sinh-vien/hien-thi", // GET
        "/sinh-vien/search", // GET
        "/sinh-vien/remove", // GET
        "/sinh-vien/detail", // GET
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
        }else if(uri.contains("detail")){
            // detail
            this.detail(request,response);
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

    private void viewAdd(HttpServletRequest request, HttpServletResponse response) {
    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) {
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) {
    }

    private void search(HttpServletRequest request, HttpServletResponse response) {
    }

    private void remove(HttpServletRequest request, HttpServletResponse response) {
    }

    private void hienThiDuLieu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("list1",svService.getListSinhVien());
        request.getRequestDispatcher("/buoi3/sinhviens.jsp").forward(request,response);
    }

    private void update(HttpServletRequest request, HttpServletResponse response) {
    }

    private void add(HttpServletRequest request, HttpServletResponse response) {
    }
}
