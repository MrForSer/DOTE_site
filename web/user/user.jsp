<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!doctype html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0"
          name="viewport">
    <meta content="ie=edge" http-equiv="X-UA-Compatible">
    <title>Пользователь</title>
    <link href="../css/user.css" rel="stylesheet">
    <link href="../images/dote-ico.png" rel="shortcut icon" type="image/x-icon">
</head>
<body>
<header>
    <div id="logo" onclick="slowScroll('#top')">
        <span>Salary Project</span>
    </div>
    <div id="about">
        <a href="${pageContext.request.contextPath}/userList"
           onclick="location.href='${pageContext.request.contextPath}/userList'"
           title="Список сотрудников">Список сотрудников</a>

        <a href="${pageContext.request.contextPath}/searchByName"
           onclick="location.href='${pageContext.request.contextPath}/searchByName'"
           title="Поиск по фамилии">Поиск по фамилии</a>

        <a href="${pageContext.request.contextPath}/searchByDepForm"
           onclick="location.href='${pageContext.request.contextPath}/searchByDepForm'"
           title="Поиск по цеху">Поиск по цеху</a>

        <a href="${pageContext.request.contextPath}/logout"
           onclick="location.href='${pageContext.request.contextPath}/logout'" title="Выход">Выход</a>
    </div>
</header>
<div id="top">
    <h1><%
        out.println("Здравствуйте, " + session.getAttribute("Name"));
    %></h1>
</div>
<footer>
    <p>Copyright by Лагунов Сергей</p>
    <p>Тел. +7(913)788-24-68</p>
    <p>E-mail: mr.forser@gmail.com</p>
</footer>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="../script.js"></script>
</body>
</html>