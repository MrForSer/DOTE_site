<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Пользователи</title>
    <link href="../css/service.css" rel="stylesheet">
    <link href="../images/dote-ico.png" rel="shortcut icon" type="image/x-icon">
</head>
<body>
<div>
    <h1>DevelopmentOnTheEdge</h1>
</div>
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

        <%-- Список пользователей на useBean + JSTL       --%>
        <jsp:useBean id="userNames" scope="request" type="java.util.List"/>
        <c:forEach items="${userNames}" var="name">
            ${name}<br>
        </c:forEach>
    </div>
</div>
<div>
    <button onclick="location.href='${pageContext.request.contextPath}/'">На главную страницу</button>
</div>
</body>
</html>