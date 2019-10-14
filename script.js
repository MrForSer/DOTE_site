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

function login() {
    document.getElementById("hide").style.display = "block";
    document.getElementById("login_form").style.display = "block";
}