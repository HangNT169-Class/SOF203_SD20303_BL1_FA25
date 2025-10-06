<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--Nhung luu y khi lam add & update:
1. method: post
2. type butotn => submit
3. action: truyen duong dan
4. input: phai co name
--%>
<form action="/sinh-vien/add" method="post">
    MSSV: <input type="text" name="mssv1"/>
    <br/>
    Tên: <input type="text" name="ten"/>
    <br/>
    Tuổi: <input type="text" name="tuoi"/>
    <br/>
    Địa chỉ: <input type="text" name="diaChi"/>
    <br/>
    Giới tính:
    <input type="radio" name="gioiTinh" checked value="true"/>Nam
    <input type="radio" name="gioiTinh" value="false"/>Nữ
    <br/>
    <button type="submit">Add</button>
</form>
</body>
</html>
