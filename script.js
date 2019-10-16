function slowScroll(id) {
    $('html, body').animate({
        scrollTop: $(id).offset().top
    }, 500);
}

$(document).on("scroll", function () {
    if ($(window).scrollTop() === 0)
        $("header").removeClass("fixed");
    else $("header").attr("class", "fixed");
});

function displayForm() {
    document.getElementById("hide").style.display = "block";
    document.getElementById("loginForm").style.display = "block";
}

function closeForm() {
    document.getElementById("hide").style.display = "none";
    document.getElementById("loginForm").style.display = "none";
}

function validate() {
    var login = document.getElementById('login').value;
    var password = document.getElementById('password').value;
    if((login == "admin") && (password == "admin")){
        alert("Данные верны");
    } else if (login == ""){
            alert("Введите логин");
    } else if (password == ""){
        alert("Введите пароль")}
    else
        alert("Логин или пароль указаны некорректно");
}

function sendMessage() {
    var name = document.getElementById('name').value;
    var email = document.getElementById('email').value;
    var message = document.getElementById('message').value;
    if(name == ""){
        alert("Укажите ваше имя");
    } else if (email == ""){
        alert("Введите адрес электронной почты");
    } else if (validateEmail(email) == false){
        alert ("Убедитесь, что адрес электронной почты введен корректно")
    } else if (message == ""){
        alert("Введите ваше сообщение")}
    else
        alert("Сообщение сохранено");
}

function validateEmail(email) {
  var re = /\S+@\S+\.\S+/;
  return re.test(email);
}