function loadXMLDoc() {
    // Объект XMLHttpRequest (или, как его кратко называют, «XHR») даёт возможность из JavaScript делать HTTP-запросы к серверу без перезагрузки страницы
    var xmlhttp = new XMLHttpRequest();
    // обработка ответа от сервера - при изменении состояния вызывается функция
    xmlhttp.onreadystatechange = function () {
        // проверка состояния и статуса (readyState = 4 ("готов") && http status = 200 ("ok"))
        if (this.readyState === 4 && this.status === 200) {
            insertData(this);
        }
    };
    xmlhttp.open("GET", "../resources/phones.xml", true);
    xmlhttp.send();
}

function insertData(xml) {
    // responseXML возвращает XML, который мы сохраняем в переменной xmlDoc
    var xmlDoc = xml.responseXML;
    // формируем таблицу для вставки на страницу
    var table = "<table id=\"phones_table\">" +
        "<tr><th>Сотрудник</th><th>Телефон</th></tr>";
    // получаем элементы xml-файла с тегом PHONE
    var phones = xmlDoc.getElementsByTagName("PHONE");
    for (var i = 0; i < phones.length; i++) {
        // вставляем в таблицу данные о человеке и его телефонном номере
        table += "<tr><td>" + phones[i].getElementsByTagName("PERSON")[0].childNodes[0].nodeValue +
            "</td><td>" + phones[i].getElementsByTagName("MOBILE_PHONE")[0].childNodes[0].nodeValue +
            "</td></tr>";
    }
    // закрываем таблицу
    table += "</tr></table><br>";
    // вставляем её на html-страницу в div "outputDiv"
    document.getElementById("outputDiv").innerHTML = table;
}