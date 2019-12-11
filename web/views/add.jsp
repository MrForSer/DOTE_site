<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!doctype html>
<html lang="ru">
<head>
    <title>Регистрация</title>
    <link href="../images/dote-ico.png" rel="shortcut icon" type="image/x-icon">
</head>
<body>
<header>
    <h1>DevelopmentOnTheEdge</h1>
</header>
<div>
    <%
        if (request.getAttribute("login") != null) {
            out.println("Пользователь " + request.getAttribute("login") + " зарегистрирован!" + System.lineSeparator());
        }
    %>
    <div>
        <div>
            <h2>Регистрация</h2>
        </div>
        <form method="post">
            <label>Логин:
                <input type="text" name="login"><br>
            </label>
            <label>Пароль:
                <input type="password" name="password"><br>
            </label>
            <label>Имя:
                <input type="text" name="firstName"><br>
            </label>
            <label>Фамилия:
                <input type="text" name="lastName"><br>
            </label>
            <button type="submit">Зарегистрироваться</button><br>
        </form>
    </div>
</div>
<div>
    <button onclick="location.href='${pageContext.request.contextPath}/'">На главную страницу</button>
</div>
</body>
</html>