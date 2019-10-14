function slowScroll(id) {
    $('html, body').animate({
        scrollTop: $(id).offset().top
    }, 500);
}

$(document).on("scroll", function () {
    if ($(window).scrollTop() === 0)
        $("header").removeClass("fixed");
    else $("header").attr("class", "fixed");
})

var modal = document.getElementById('login_form');

function displayForm() {
    document.getElementById("hide").style.display = "block";
    document.getElementById("login_form").style.display = "block";
}

function closeWindow() {
    document.getElementById("hide").style.display = "none";
    document.getElementById("login_form").style.display = "none";
}