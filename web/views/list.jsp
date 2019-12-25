<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!doctype html>
<html lang="ru">
<head>
    <title>Сотрудники</title>
    <link href="../images/dote-ico.png" rel="shortcut icon" type="image/x-icon">
</head>
<body>
<header>
    <h1>SalaryProject</h1>
</header>
<div>
    <div>
        <div>
            <h2>Сотрудники</h2>
        </div>
        <jsp:useBean id="employeesData" scope="request" type="java.util.List"/>
        <ul>
            <c:forEach items="${employeesData}" var="empData">
                <li>${empData}</li>
            </c:forEach>
        </ul>
        <br>
    </div>
</div>
<div>
    <button onclick="location.href='${pageContext.request.contextPath}/'">На главную страницу</button>
</div>
</body>
</html>