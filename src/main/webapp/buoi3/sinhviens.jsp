<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Quản lý sinh viên</h1>
<form action="/sinh-vien/search">
    Tên: <input name="ten"/>
    <button type="submit">Search</button>
</form>
<br/>
<button><a href="/sinh-vien/view-add">Add Student</a></button>
<table>
    <tr>
        <th>STT</th>
        <th>MSSV</th>
        <th>Tên</th>
        <th>Tuổi</th>
        <th>Địa chỉ</th>
        <th>Giới tính</th>
        <th colspan="2">Action</th>
    </tr>
    </thead>
    <tbody>
        <%--JSP: for if.. switch..case
        => Bat buoc add jstl
        --%>
        <%--for..each :
        for(SinhVien sv: listSinhVien){

        }
        --%>
        <c:forEach items="${list1}" var="sv" varStatus="i">
            <tr>
                <%-- Ten bien phan trung trong entity --%>
                <%-- varStatus: Liet ke vi tri cac tu trong mang --%>
                <td>${i.index + 1}</td>
                <td>${sv.mssv1}</td>
                <td>${sv.ten}</td>
                <td>${sv.tuoi}</td>
                <td>${sv.diaChi}</td>
                <td>${sv.gioiTinh}</td>
                <td>
                    <%--"%20": Khong duoc phep co khoang cach
                    Chi duy nhat 1 => ?
                    Tu ths 2 => &
<a href="/sinh-vien/remove?a=${sv.mssv1}&b=${sv.ten}&c=${sv.tuoi}">Remove</a>
                    --%>
                    <a href="/sinh-vien/remove?a1=${sv.mssv1}">Remove</a>
                    <a href="/sinh-vien/view-update?mssv=${sv.mssv1}">Detail</a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>
