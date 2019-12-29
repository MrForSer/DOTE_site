$(document).ready(function () {
    $('#login').blur(function () {
        $.ajax({
            url: 'CheckUserLoginServlet',
            data: {
                login: $('#login').val()
            },
            success: function (responseText) {
                $('#ajaxCheckUserLoginServlet').text(responseText);
            }
        });
    });
});