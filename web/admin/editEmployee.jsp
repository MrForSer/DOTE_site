<%@ page contentType="text/html; charset=UTF-8" %>
<%@page import="ru.nstu.forser.dao.EmployeeDAO" %>
<jsp:useBean id="employee" class="ru.nstu.forser.entities.Employee">
    <jsp:setProperty property="*" name="employee"/>
</jsp:useBean>

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
    EmployeeDAO employeeDAO = new EmployeeDAO();
    employeeDAO.update(employee);
    response.sendRedirect(request.getContextPath() + "/adminList");
%>
</body>
</html>