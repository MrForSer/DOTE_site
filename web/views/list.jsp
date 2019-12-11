<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!doctype html>
<html lang="ru">
<head>
    <title>Пользователи</title>
    <link href="../images/dote-ico.png" rel="shortcut icon" type="image/x-icon">
</head>
<body>
<header>
    <h1>DevelopmentOnTheEdge</h1>
</header>
<div>
    <div>
        <div>
            <h2>Пользователи</h2>
        </div>
        <%-- Список пользователей на скриптлете: --%>
        <%--        <%--%>
        <%--            List<String> names = (List<String>) request.getAttribute("userNames");--%>
        <%--            if (names != null && !names.isEmpty()) {--%>
        <%--                out.println("<ui>");--%>
        <%--                for (String name : names) {--%>
        <%--                    out.println("<li>" + name + "</li>");--%>
        <%--                }--%>
        <%--                out.println("</ui>");--%>
        <%--            } else out.println("<p>Пользователи не найдены</p>");--%>
        <%--        %>--%>

        <%-- Список пользователей с использованием useBean + JSTL --%>
        <jsp:useBean id="userNames" scope="request" type="java.util.List"/>
        <ul>
            <c:forEach items="${userNames}" var="name">
                <li>${name}</li>
            </c:forEach>
        </ul>
        <br>
    </div>
</div>
<div>
    <button onclick="location.href='${pageContext.request.contextPath}/'">На главную страницу</button>
</div>
</body>
</html>