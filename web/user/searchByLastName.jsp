<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!doctype html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0"
          name="viewport">
    <meta content="ie=edge" http-equiv="X-UA-Compatible">
    <title>Поиск работника</title>
    <link href="../css/user.css" rel="stylesheet">
    <link href="../images/dote-ico.png" rel="shortcut icon" type="image/x-icon">
</head>
<body>
<form method="post" action="search">
    <table>
        <tr>
            <td>
                <h3>Поиск сотрудника</h3></td>
        </tr>
        <tr>
            <td><strong>Фамилия:</strong></td>
            <td><input type="text" name="lastName" id="lastName"></td>
        </tr>
        <tr>
            <td colspan=2>
                <input type="submit" name="submit" value="Найти"></td>
        </tr>
    </table>
</form>
</body>
</html>