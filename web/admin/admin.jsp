<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!doctype html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0"
          name="viewport">
    <meta content="ie=edge" http-equiv="X-UA-Compatible">
    <title>Администратор</title>
    <link href="../css/admin.css" rel="stylesheet">
    <link href="../images/dote-ico.png" rel="shortcut icon" type="image/x-icon">
</head>
<body>
<header>
    <div id="logo" onclick="slowScroll('#top')">
        <span>DevelopmentOnTheEdge</span>
    </div>
    <div id="about">
        <a href="${pageContext.request.contextPath}/addUser"
           onclick="location.href='${pageContext.request.contextPath}/addUser'"
           title="Регистрация пользователя">Регистрация пользователя</a>
        <a href="${pageContext.request.contextPath}/addEmployee"
           onclick="location.href='${pageContext.request.contextPath}/addEmployee'"
           title="Добавить работника">Добавить работника</a>
        <a href="${pageContext.request.contextPath}/adminList"
           onclick="location.href='${pageContext.request.contextPath}/adminList'" title="Список работников">Список
            работников</a>
        <a href="${pageContext.request.contextPath}/logout"
           onclick="location.href='${pageContext.request.contextPath}/logout'" title="Выход">Выход</a>
    </div>
</header>
<div id="top">
</div>
<footer>
    <p>Copyright by Лагунов Сергей</p>
    <p>Тел. +7(913)788-24-68</p>
    <p>E-mail: mr.forser@gmail.com</p>
</footer>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="../js/script.js"></script>
</body>
</html>