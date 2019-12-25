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
    <link href="css/main.css" rel="stylesheet">
    <link href="images/dote-ico.png" rel="shortcut icon" type="image/x-icon">
</head>
<body>
<header>
    <div id="logo" onclick="slowScroll('#top')">
        <span>Salary Project</span>
    </div>
    <div id="about">
        <a href="${pageContext.request.contextPath}/add"
           onclick="location.href='${pageContext.request.contextPath}/add'" title="Регистрация">Регистрация</a>
        <a href="${pageContext.request.contextPath}/list"
           onclick="location.href='${pageContext.request.contextPath}/list'" title="Сотрудники">Сотрудники</a>
    </div>
</header>
<div id="top">
    <h1>Administrator page</h1>
</div>
<footer>
    <p>Copyright by Лагунов Сергей</p>
    <p>Тел. +7(913)788-24-68</p>
    <p>E-mail: mr.forser@gmail.com</p>
</footer>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="script.js"></script>
</body>
</html>