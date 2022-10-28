<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Configuration</title>
</head>
<body>
<h2>Configuration Information</h2>
<table>
  <tr>
    <td>Languages: </td>
    <td>${configuration.languages}</td>
  </tr>
  <tr>
    <td>Page Size:</td>
    <td>${configuration.pageSize}</td>
  </tr>
  <tr>
    <td>Spams fillter:</td>
    <td>${configuration.spamsFillter}</td>
  </tr>
  <tr>
    <td>Signature: </td>
    <td>
      <textarea>
      ${configuration.signature}
      </textarea>
    </td>
  </tr>
</table>
<a href="/edit">
  <button type="button">Seetings</button>
</a>
</body>
</html>
