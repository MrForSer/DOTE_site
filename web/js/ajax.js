// проверка состояния страницы
$(document).ready(function () {
    // запуск при потере фокуса на поле
    $('#login').blur(function () {
        $.ajax({
            // url куда будут переданы данные
            url: 'CheckUserLoginServlet',
            // сами данные для передачи
            data: {
                login: $('#login').val()
            },
            // обработка полученных данных
            success: function (responseText) {
                $('#ajaxCheckUserLoginServlet').text(responseText);
            }
        });
    });
});