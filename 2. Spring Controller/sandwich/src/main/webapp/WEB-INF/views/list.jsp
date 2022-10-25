<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Menu</title>
</head>
<body>
<h2> List Gia vi</h2>
<ol>
    <c:forEach items="${condiment}" var="c">
        <li>
            <c:out value="${c}"/>
        </li>
    </c:forEach>
</ol>

</body>
</html>
