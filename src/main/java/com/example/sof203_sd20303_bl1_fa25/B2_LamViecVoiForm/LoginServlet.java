package com.example.sof203_sd20303_bl1_fa25.B2_LamViecVoiForm;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

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
        // Java class => giao dien
        int a = 5;
        String mess ="Xin chao SOF203";
//         setAttribute(ten bien truyen jsp, gia tri truyen di);
        request.setAttribute("mess1",mess);
        request.setAttribute("number",a);
        request.getRequestDispatcher("/buoi1/login-form.jsp").forward(request,response);
        // C2: sendRedirect => k mang du lieu truyen di
//        response.sendRedirect("/buoi1/login-form.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Ket - qua
        // B1: Lay du lieu tu jsp => servlet: getParameter
        String username = request.getParameter("uname");
        String password = request.getParameter("pass");
        // Check validate
        
        // B2: Truyen servlet => jsp
        request.setAttribute("u1",username);
        request.setAttribute("u2",password);
        // B3: Chuyen trang
        request.getRequestDispatcher("/buoi1/ket-qua-form.jsp").forward(request,response);

    }
}
