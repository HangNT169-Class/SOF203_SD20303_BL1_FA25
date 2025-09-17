package com.example.sof203_sd20303_bl1_fa25.B2_LamViecVoiForm;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
//@: anotation
@WebServlet( value = {
        "/login","/ket-qua"
})
/**
 * Web servlet :
 *   + name: option (có cũng được k cũng k sao)
 *   + value: bắt buộc có: là nơi liệt kê tất cả các đường dẫn
 * Một số lưu ý về đường dẫn:
 *   + Bắt đầu bằng dấu /
 *   + Đường dẫn là duy nhất
 */
public class LoginServlet extends HttpServlet {

    // BE & FE : HTTP Methods
    // GET, POST, PUT, DELETE

    // C: CREATE <=> INSERT: POST
    // R: READ <=> SELECT : GET
    // U: UPDATE <=> UPDATE: PUT
    // D: DELETE <=> DELETE: DELETE

    // J3, J4, J5: 2 phuong thuc: GET & POST
    // GET: Lay, hien thi
    // POST: xu ly form

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // chuyen sang trang jsp
        // C1: getRequestDispatcher
        // Truyen du lieu tu servlet => jsp
//        int a = 5;
//        String mess ="Xin chao SOF203";
//        // setAttribute(ten bien truyen jsp, gia tri truyen di)
//        request.setAttribute("mess1",mess);
//        request.getRequestDispatcher("/buoi1/login-form.jsp").forward(request,response);
        // C2: sendRedirect => k mang du lieu truyen di
        response.sendRedirect("/buoi1/login-form.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
