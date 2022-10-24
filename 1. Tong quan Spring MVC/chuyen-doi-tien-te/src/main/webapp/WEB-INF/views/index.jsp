<%--
  Created by IntelliJ IDEA.
  User: Hiếu Nguyễn
  Date: 10/24/2022
  Time: 3:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Trang chu</title>
</head>
<body>
<form method="get" action="/convert">
    <input type="number" placeholder="Tỉ giá" name="rate" style="width: 300px">
    <input type="number" placeholder="USD" name="amount" style="width: 300px">
    <button type="submit" value="Chuyển đổi">Chuyển đổi</button>
</form>
</body>
</html>
