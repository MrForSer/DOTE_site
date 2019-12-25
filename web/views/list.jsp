<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!doctype html>
<html lang="ru">
<head>
    <title>Сотрудники</title>
    <link href="../images/dote-ico.png" rel="shortcut icon" type="image/x-icon">
</head>
<body>
<header>
    <h1>SalaryProject</h1>
</header>
<div>
    <div>
        <div>
            <h2>Сотрудники</h2>
        </div>
        <%--        <jsp:useBean id="employeesData" scope="request" type="java.util.List"/>--%>
        <jsp:useBean id="employees" scope="request" type="java.util.List"/>
        <table border="1">
            <tr>
                <th>ИД</th>
                <th>Работник</th>
                <th>Цех</th>
                <th>Зарплата</th>
                <th>Разряд</th>
                <th>Редактировать</th>
                <th>Удалить</th>
            </tr>
            <c:forEach items="${employees}" var="employee">
                <tr>
                    <td>${employee.getId()}</td>
                    <td>${employee.getLastName()}</td>
                    <td>${employee.getDepartment()}</td>
                    <td>${employee.getSalary()}</td>
                    <td>${employee.getRank()}</td>
                    <td><a href="editform.jsp?id=${employee.getId()}">Редактировать</a></td>
                    <td><a href="deleteuser.jsp?id=${employee.getId()}">Удалить</a></td>
                </tr>
            </c:forEach>
        </table>

        <%--        <ul>--%>
        <%--            <c:forEach items="${employeesData}" var="empData">--%>
        <%--                <li>${empData}</li>--%>
        <%--                <div id="edit">--%>
        <%--                    <a href="#" onclick="displayUpdateForm()" title="Редактировать">Редактировать</a>--%>
        <%--                </div>--%>
        <%--            </c:forEach>--%>
        <%--        </ul>--%>
        <br>
    </div>
</div>
<div>
    <button onclick="history.back()">Назад</button>
</div>
<%--<div class="hide" id="hide"></div>--%>
<%--<div class="updateForm" id="updateForm">--%>
<%--    <form name="Форма редактирования" action="update">--%>
<%--        <input type="text" name="login" size="25"/>--%>
<%--        <input type="password" name="password" size=25/>--%>

<%--        <input type="submit" value="Войти">--%>
<%--        <input type="reset" value="Очистить форму">--%>
<%--    </form>--%>
<%--</div>--%>
<script src="../script.js"></script>
</body>
</html>