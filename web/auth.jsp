<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Авторизация</title>
    <script>setTimeout(function () {
        window.location.href = "/DOTE_site/";
    }, 3000);</script>
</head>
<body>
<jsp:useBean id="mybean" scope="session" class="ru.nstu.forser.Authorisation" />
<jsp:setProperty name="mybean" property="login" />
<jsp:setProperty name="mybean" property="password" />
Добро пожаловать, <jsp:getProperty name="mybean" property="login" />. Авторизация прошла успешно.
</body>
</html>