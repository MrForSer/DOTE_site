<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Авторизация</title>
    <script>setTimeout(function () {
        window.location.href = "/DOTE_site/admin";
    }, 1000);</script>
</head>
<body>
<jsp:useBean id="mybean" scope="session" class="ru.nstu.forser.entities.User"/>
<jsp:setProperty name="mybean" property="firstName"/>
<jsp:setProperty name="mybean" property="password"/>
Добро пожаловать,
<jsp:getProperty name="mybean" property="firstName"/>
. Авторизация прошла успешно.
</body>
</html>
