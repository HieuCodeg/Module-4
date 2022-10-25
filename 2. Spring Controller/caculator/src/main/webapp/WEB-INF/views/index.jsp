<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Restaurent</title>

</head>
<body>
<h2>Caculator</h2>

<form  action="/caculator" method="get">
    <input type="number"  name="first"  value="${first}" style="width: 100px;">
    <input type="number"  name="second" value="${second}" style="width: 100px;">
    <button type="submit" value="+" name="operation">Addition(+)</button>
    <button type="submit" value="-" name="operation">Subtraction(-)</button>
    <button type="submit" value="*" name="operation">Mutiplication(X)</button>
    <button type="submit" value="/" name="operation">Division(/)</button>
</form>
<h3> Result: <c:out value="${result}"/></h3>
</body>
</html>