<%@ page import="java.util.List" %>
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
        <%
            List<String> names = (List<String>) request.getAttribute("userNames");

            if (names != null && !names.isEmpty()) {
                out.println("<ui>");
                for (String name : names) {
                    out.println("<li>" + name + "</li>");
                }
                out.println("</ui>");
            } else out.println("<p>Пользователи не найдены</p>");
        %>
    </div>
</div>
<div>
    <button onclick="location.href='/'">На главную страницу</button>
</div>
</body>
</html>