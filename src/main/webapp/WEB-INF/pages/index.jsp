<%--
  Created by IntelliJ IDEA.
  User: Tsyplik
  Date: 10.09.2019
  Time: 19:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/index" method="get">

    Hello there, ${sessionScope.name}

</form>

</body>
</html>
