package com.example.sof203_sd20303_bl1_fa25.B10_JDBC.servlet;

import com.example.sof203_sd20303_bl1_fa25.B10_JDBC.repository.CategoryRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "CategoryServlet", value = "/category/hien-thi")
public class CategoryServlet extends HttpServlet {

    private CategoryRepository repository = new CategoryRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("hien-thi")){
            this.hienThiDuLieu(request,response);
        }
    }

    private void hienThiDuLieu(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("lists",repository.getAll());
        //...
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
