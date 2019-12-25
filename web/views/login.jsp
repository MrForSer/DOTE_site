<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Логин</title>
</head>
<body>
<div class="loginForm" id="loginForm">
    <form name="Форма авторизации" action="views/welcome.jsp">
        <input type="text" name="login" size="25"/>
        <input type="password" name="password" size=25/>
        <input type="submit" value="Войти">
        <input type="reset" value="Очистить форму">
    </form>
</div>
</body>
</html>