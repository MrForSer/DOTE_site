<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0"
          name="viewport">
    <meta content="ie=edge" http-equiv="X-UA-Compatible">
    <title>DevelopmentOnTheEdge</title>
    <link href="../css/admin.css" rel="stylesheet">
    <link href="../images/dote-ico.png" rel="shortcut icon" type="image/x-icon">
</head>
<body>
<header>
    <div id="logo" onclick="slowScroll('#top')">
        <span>DevelopmentOnTheEdge</span>
    </div>
    <div id="about">
        <a href="#" onclick=location.href="/DOTE_site" title="На главную">На главную</a>
    </div>
</header>

<div id="admin">
    Список пользователей:
    <jsp:useBean id="UserBean" scope="page" class="ru.nstu.forser.beans.UserBeanImpl"/>
    <jsp:getProperty name="UserBean" property="users"/>
</div>

<!-- JQuery скрипт для медленного скроллинга на нужный раздел сайта при нажатии на ссылку -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="../script.js"></script>
</body>
</html>