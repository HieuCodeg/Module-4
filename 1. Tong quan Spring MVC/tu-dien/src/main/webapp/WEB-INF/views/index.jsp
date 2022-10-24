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
<form method="get" action="/index">
    <label for="english">English</label>
    <input  id="english" type="text"  name="english" value="${english}" style="width: 300px">
    <label for="meaning">Meaning</label>
    <input id="meaning" type="text"  name="meaning" value="${meaning}" style="width: 300px">
    <button type="submit" >Dịch</button>
</form>
</body>
</html>
