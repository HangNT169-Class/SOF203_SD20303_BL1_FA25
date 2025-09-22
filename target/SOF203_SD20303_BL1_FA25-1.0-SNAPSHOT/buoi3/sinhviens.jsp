<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="">
    Tên: <input name="ten"/>
    <button type="submit">Search</button>
</form>
<br/>
<button><a href="">Add Student</a></button>
<table border="1">
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
        <c:forEach items="${list1}" var="sv">
            <tr>
                <%-- Ten bien phan trung trong entity --%>
                <td></td>
                <td>${sv.mssv1}</td>
                <td>${sv.ten}</td>
                <td>${sv.tuoi}</td>
                <td>${sv.diaChi}</td>
                <td>${sv.gioiTinh}</td>
                <td></td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>
