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
    <script type="text/javascript">
        function VerifyUsername() {
            //alert("In Verify Method");
            var name = document.getElementById("lastName").value;
            //alert(name);
            var xmlhttp;
            if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
                xmlhttp = new XMLHttpRequest();
                //alert("http");
            } else {// code for IE6, IE5
                xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
                alert("http active");
            }
            xmlhttp.onreadystatechange = function () {
                //alert("in Function()");
                if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                    try {
                        //alert("In Try");
                        document.getElementById("errorpass").innerHTML = xmlhttp.responseText;
                        /*var response = xmlhttp.responseText;
                        alert(response);
                        if(response.toString()=='notmatch')
                        {
                            alert("Ok");
                            document.getElementById("errorpass").innerHTML ="OK";
                        }
                        if(response =='match')
                        {
                            alert("Not Ok");
                            document.getElementById("errorpass").innerHTML ="Take Other Name.";
                        }*/
                    } catch (ex) {
                        alert("Exception in function " + ex);
                    }
                }
            }
            //xmlhttp.open("POST","servlet/UsernamePresence_Serv?UserId"+name,true);
            xmlhttp.open("POST", "servlet/UsernamePresence_Serv?" + name, true);
            var params = "UserId=" + name;
            xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
            xmlhttp.setRequestHeader("Content-length", params.length);
            xmlhttp.setRequestHeader("Connection", "close");
            xmlhttp.send(params);
        }
    </script>
</head>
<body>
<form method="post" action="searchByLastName">
    <h3>Поиск сотрудника по фамилии</h3></td>
    <strong>Фамилия:</strong>
    <input type="text" name="lastName" id="lastName">
    <input type="submit" name="submit" value="Найти">
</form>
</body>
</html>