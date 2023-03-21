<%--
  Created by IntelliJ IDEA.
  User: adssr
  Date: 2023-03-02
  Time: 2:09 a.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Geo</title>
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="container p-3 my-3 border">
    <h1>Level ${level} Geographical Areas Classification List</h1>


    <form action="<%= request.getContextPath()%>/geo">
        <label class="text-primary" for="levelValue">Select a Geo Level</label>
        <select class="form-control" name="levelValue" id="levelValue">
            <option value="0">Level 0 </option>
            <option value="1">Level 1 </option>
            <option value="2">Level 2</option>
            <option value="3">Level 3</option>
        </select>
        <br/>
        <button type="submit" class="btn btn-outline-info">Get List</button>

    </form>
    </br></br>
    <form action="<%= request.getContextPath()%>/age" method="GET">
        <input type="hidden" name="yearId" value="1">
        <button type="submit" class="btn btn-outline-info">Age List</button>
    </form>


    <table class="table table-striped">
        <thead>
        <tr>
            <th>Geographic Area Id</th>
            <th>Code</th>
            <th>Level</th>
            <th>Name</th>
            <th>Alternative Code</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="item" items="${geos}">
            <tr>
                <td>${item.id}</td>
                <td>${item.code}</td>
                <td>${item.level}</td>
                <td>${item.name}</td>
                <td>${item.alternativeCode}</td>
                <td><a href="<%= request.getContextPath()%>/geoDetails?id=${item.id}">Details</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>



</body>
</html>
