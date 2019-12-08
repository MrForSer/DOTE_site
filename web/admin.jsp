<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Авторизация</title>
    <script>setTimeout(function () {
        window.location.href = "/DOTE_site/admin";
    }, 300);</script>
</head>
<body>
<jsp:useBean id="mybean" scope="session" class="ru.nstu.forser.entities.User"/>
<jsp:setProperty name="mybean" property="login"/>
<jsp:setProperty name="mybean" property="password"/>
Добро пожаловать,
<jsp:getProperty name="mybean" property="login"/>
. Авторизация прошла успешно.
</body>
</html>
