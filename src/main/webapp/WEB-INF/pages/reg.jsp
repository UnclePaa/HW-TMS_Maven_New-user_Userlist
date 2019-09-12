<%@ page import="javax.xml.namespace.QName" %><%--
  Created by IntelliJ IDEA.
  User: Tsyplik
  Date: 10.09.2019
  Time: 20:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/reg" method="post">

    Please fill the form below
    <br>
    <input placeholder="Name" type="text" name="name">
    <br>
    <input placeholder="Age" type="text" name="age">
    <br>
    <input placeholder="Password" type="text" name="pass">
    <br>
    <button type="submit">Submit</button>
    <br>
</form>
</body>
</html>
