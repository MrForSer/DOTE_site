<%@ page import="ru.nstu.forser.dao.UserDAO" %>
<%@ page import="ru.nstu.forser.entities.User" %>
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
<jsp:useBean id="userBean" scope="session" class="ru.nstu.forser.entities.User"/>
<jsp:setProperty name="userBean" property="login"/>
<jsp:setProperty name="userBean" property="password"/>
<%
    UserDAO userDAO = new UserDAO();
    User user = userDAO.findUser(userBean.getLogin(), userBean.getPassword());
    if (user != null) {
        out.println("Здравствуйте, " + user.getFirstName() + " " + user.getLastName() + "!" + System.lineSeparator());
    } else {
        out.println("Пользователь не найден, попробуйте еще раз.");
    }
%>
</body>
</html>