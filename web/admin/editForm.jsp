<%@ page contentType="text/html; charset=UTF-8" %>
<%@page import="ru.nstu.forser.dao.EmployeeDAO, ru.nstu.forser.entities.Employee" %>
<!doctype html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0"
          name="viewport">
    <meta content="ie=edge" http-equiv="X-UA-Compatible">
    <title>Редактировать сотрудника</title>
    <link href="../images/dote-ico.png" rel="shortcut icon" type="image/x-icon">
</head>
<body>
<%
    String id = request.getParameter("id");
    EmployeeDAO employeeDAO = new EmployeeDAO();
    Employee employee = employeeDAO.findById(Integer.parseInt(id));
%>
<h1>Редактировать сотрудника</h1>
<form action="editEmployee.jsp" method="post">
    <input type="hidden" name="id" value="<%=employee.getId() %>"/>
    <table>
        <tr>
            <td>Фамилия:</td>
            <td>
                <input type="text" name="lastName" value="<%= employee.getLastName()%>"/></td>
        </tr>
        <tr>
            <td>Цех:</td>
            <td>
                <input type="text" name="department" value="<%= employee.getDepartment()%>"/></td>
        </tr>
        <tr>
            <td>Зарплата:</td>
            <td>
                <input type="number" name="salary" value="<%= employee.getSalary()%>"/></td>
        </tr>
        <tr>
            <td>Разряд:</td>
            <td>
                <input type="number" name="rank" value="<%= employee.getRank()%>"/></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Редактировать сотрудника"/></td>
        </tr>
    </table>
</form>
</body>
</html>