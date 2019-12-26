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
                    <td><a href="${pageContext.request.contextPath}/admin/editForm.jsp?id=${employee.getId()}">Редактировать</a>
                    </td>
                    <td><a href="${pageContext.request.contextPath}/admin/deleteEmployee.jsp?id=${employee.getId()}">Удалить</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <br>
    </div>
</div>
<div>
    <button onclick="location.href='${pageContext.request.contextPath}/admin/admin.jsp'">Назад</button>
</div>
<script src="../script.js"></script>
</body>
</html>