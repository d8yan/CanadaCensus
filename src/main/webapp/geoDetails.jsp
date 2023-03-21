<%--
  Created by IntelliJ IDEA.
  User: adssr
  Date: 2023-03-02
  Time: 5:31 a.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Geo Details</title>
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="container p-3 my-3 border">
    <h1><c:out value="${geoDetails.name}" />'s Details</h1>
    <label class="text-success" for="id">Geographic Area ID: </label>
    <p class="text-success" id="id" style="display: inline"><c:out value="${geoDetails.id}" /></p></br>
    <label class="text-success" for="code">Code: </label>
    <p class="text-success" id="code" style="display: inline"><c:out value="${geoDetails.code}" /></p></br>
    <label class="text-success" for="level">Level: </label>
    <p class="text-success" id="level" style="display: inline"><c:out value="${geoDetails.level}" /></p></br>
    <label class="text-success" for="name">Name: </label>
    <p class="text-success" id="name" style="display: inline"><c:out value="${geoDetails.name}" /></p></br>
    <label class="text-success" for="altCode">Alternative Code: </label>
    <p class="text-success" id="altCode" style="display: inline"><c:out value="${geoDetails.alternativeCode}" /></p></br>
    <label class="text-success" for="population">Population: </label>
    <p class="text-success" id="population" style="display: inline"><c:out value="${geoDetails.totalPopulation}" /></p></br>

    <form action="<%= request.getContextPath()%>/geo" method="GET">
        <input type="hidden" name="levelValue" value="${geoDetails.level}">
        <button type="submit" class="btn btn-outline-primary">Go Back</button>
    </form>
</div>

</body>
</html>
