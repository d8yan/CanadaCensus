<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="container">
    <div class="jumbotron">
        <h2 class="text-info"><%= "Welcome to Group 5 Project!" %>
        </h2>
        <h3 class="text-info">Group Members: Adriel Roque, Almas Khan, Dong Yan</h3>
        <br/>
        <a href="login.jsp">Login</a>
    </div>
</div>
</body>
</html>