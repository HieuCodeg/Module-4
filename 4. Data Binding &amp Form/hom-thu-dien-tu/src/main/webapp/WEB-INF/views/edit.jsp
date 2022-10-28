<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
  <title>Cau hinh</title>
</head>
<body>
<h2>Settings</h2>
<form:form method="POST" action="update" modelAttribute="configuration">
  <table>
    <tr>
      <td><form:label path="languages">Languages: </form:label></td>
      <td>
        <form:select path="languages" items="${listLanguages}" />
      </td>
    </tr>
    <tr>
      <td><form:label path="pageSize">Page Size: </form:label></td>
      <td>
        Show
        <form:select path="pageSize" items="${listPageSize}" />
        emails per page
      </td>
    </tr>
    <tr>
      <td><form:label path="spamsFillter">Spams Fillter: </form:label></td>
      <td><form:checkbox path="spamsFillter" value="true"/> Enable spams fillter </td>
    </tr>
    <tr>
      <td><form:label path="signature">Signature: </form:label></td>
      <td><form:textarea path="signature" /></td>
    </tr>
    <tr>
      <td><input type="submit" value="Submit"/></td>
    </tr>
  </table>
</form:form>
</body>
</html>
