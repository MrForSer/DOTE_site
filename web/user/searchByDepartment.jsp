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
<form method="post" action="searchByDepartment">
    <h3>Поиск работников по цеху</h3>
    <label>Цех:
        <select name="department">
            <option value="Цех 1">Цех 1</option>
            <option value="Цех 2">Цех 2</option>
            <option value="Цех 3">Цех 3</option>
            <option value="Цех 4">Цех 4</option>
        </select>
    </label>
    <br>
    <br>
    <input type="submit" name="submit" value="Найти">
</form>
</body>
</html>