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
<div>
    <div>
        <h2>Зарплаты по цехам</h2>
    </div>
    <jsp:useBean id="salaries" scope="request" type="java.util.List"/>
    <ul>
        <c:forEach items="${salaries}" var="salary">
            <li>${salary}</li>
        </c:forEach>
    </ul>
    <br>
</div>
<div>
    <button onclick="history.back()">Назад</button>
</div>
<script src="../script.js"></script>
</body>
</html>