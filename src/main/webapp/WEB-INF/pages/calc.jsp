<%--
  Created by IntelliJ IDEA.
  User: Tsyplik
  Date: 10.09.2019
  Time: 20:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/calc" method="post">
    <input placeholder="Number 1" type="number" name="num1">
    <br>
    <input placeholder="Number 2" type="number" name="num2">
    <br>
    <input placeholder="Action" type="text" name="act">
    <button type="submit">Calculate</button>

</form>
</body>
</html>
