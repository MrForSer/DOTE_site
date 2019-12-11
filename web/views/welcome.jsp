<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Авторизация</title>
    <script>setTimeout(function () {
        window.location.href = "/DOTE_site";
    }, 1000);</script>
</head>
<body>
<jsp:useBean id="userBean" scope="session" class="ru.nstu.forser.entities.User"/>
<jsp:setProperty name="userBean" property="login"/>
<jsp:setProperty name="userBean" property="password"/>
Добро пожаловать,
<jsp:getProperty name="userBean" property="login"/>
. Мы рады вас снова видеть!
</body>
</html>
