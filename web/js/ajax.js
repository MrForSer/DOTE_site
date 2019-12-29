//$(document).ready(function() {
//        $('#userName').blur(function(event) {
//                var name = $('#userName').val();
//                $.get('GetUserServlet', {
//                        userName : name
//                }, function(responseText) {
//                        $('#ajaxGetUserServletResponse').text(responseText);
//                });
//        });
//});
//

$(document).ready(function () {
    $('#login').blur(function () {
        $.ajax({
            url: 'GetUserServlet',
            data: {
                login: $('#login').val()
            },
            success: function (responseText) {
                $('#ajaxGetUserServletResponse').text(responseText);
            }
        });
    });
});