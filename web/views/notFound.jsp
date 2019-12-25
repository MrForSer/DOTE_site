<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!doctype html>
<html lang="ru">
<head>
    <title>Авторизация</title>
    <script>setTimeout(function () {
        window.location.href = "${pageContext.request.contextPath}/";
    }, 1000);</script>
</head>
<body>
<%
    out.println("Пользователь не найден, попробуйте еще раз.");
%>
</body>
</html>