<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!doctype html>
<html lang="ru">
<head>
    <title>Добавление сотрудника</title>
    <link href="../images/dote-ico.png" rel="shortcut icon" type="image/x-icon">
</head>
<body>
<header>
    <h1>SalaryProject</h1>
</header>
<div>
    <%
        if (request.getAttribute("lastName") != null) {
            out.println("Сотрудник " + request.getAttribute("lastName") + " добавлен!" + System.lineSeparator());
        }
    %>
    <div>
        <div>
            <h2>Добавление сотрудника</h2>
        </div>
        <form method="post">
            <label>Фамилия:
                <input type="text" name="lastName"><br>
            </label>
            <label>Цех:
                <select name="department">
                    <option value="Цех 1">Цех 1</option>
                    <option value="Цех 2">Цех 2</option>
                    <option value="Цех 3">Цех 3</option>
                    <option value="Цех 4">Цех 4</option>
                </select><br>
            </label>
            <label>Зарплата:
                <input type="number" name="salary"><br>
            </label>
            <label>Категория:
                <input type="number" name="rank"><br>
            </label>
            <button type="submit">Добавить</button>
            <br>
        </form>
    </div>
</div>
<div>
    <button onclick="location.href='${pageContext.request.contextPath}/admin/admin.jsp'">Назад</button>
</div>
</body>
</html>