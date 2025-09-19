<%--
  Created by IntelliJ IDEA.
  User: hangnt
  Date: 17/9/25
  Time: 08:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
${mess1} - ${number}
<%--
1. Phai action => truyen duong dan
2. Phuong thuc phai => POST
3. Type button: submit
4. input => Phai co thuoc name
--%>
<form action="/ket-qua" method="POST">
    <label>Username:</label><input type="text" name="uname">
    <br>
    <label>Password:</label><input type="password" name="pass">
    <br>
    <button type="submit">Login</button>
</form>
</body>
</html>
