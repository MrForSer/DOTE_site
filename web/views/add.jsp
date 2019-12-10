<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Регистрация</title>
    <link href="../css/service.css" rel="stylesheet">
    <link href="../images/dote-ico.png" rel="shortcut icon" type="image/x-icon">
    <meta charset="UTF-8"/>
</head>

<body>
<div id="logo" onclick="slowScroll('#top')">
    <h1>DevelopmentOnTheEdge</h1>
</div>
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
                <input type="text" name="login"><br/>
            </label>
            <label>Пароль:
                <input type="password" name="password"><br/>
            </label>
            <label>Имя:
                <input type="text" name="firstName"><br/>
            </label>
            <label>Фамилия:
                <input type="text" name="lastName"><br/>
            </label>
            <button type="submit">Зарегистрироваться</button>
        </form>
    </div>
</div>

<div>
    <button onclick="location.href='/'">На главную страницу</button>
</div>
</body>
</html>