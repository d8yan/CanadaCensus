<%--
  Created by IntelliJ IDEA.
  User: adssr
  Date: 2023-03-02
  Time: 2:07 a.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
  <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="container">
  <h1>Login</h1>
  <p class="text-danger">${message}</p>
  <div class="card">
    <div class="card-body">
  <form action="<%= request.getContextPath()%>/login" method="post">
    <div class="form-group row">
      <label for="username" class="col-sm-2 col-form-label">Username: </label>
      <div class="col-sm-7">
        <input type="text" class="form-control" id="username" name="username" placeholder="Enter user name" />
      </div>
    </div>
    <div class="form-group row">
      <label for="password" class="col-sm-2 col-form-label">Password: </label>
      <div class="col-sm-7">
        <input type="password" id="password" class="form-control" name="password"
               placeholder="Enter Password">
      </div>
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
  </form>
    </div>
  </div>
</div>
</body>
</html>



