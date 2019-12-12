<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!doctype html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0"
          name="viewport">
    <meta content="ie=edge" http-equiv="X-UA-Compatible">
    <title>DevelopmentOnTheEdge</title>
    <link href="css/main.css" rel="stylesheet">
    <link href="images/dote-ico.png" rel="shortcut icon" type="image/x-icon">
</head>
<body>
<header>
    <div id="logo" onclick="slowScroll('#top')">
        <span>DevelopmentOnTheEdge</span>
    </div>
    <div id="about">
        <a href="#" onclick="slowScroll('#main')" title="Возможности">Возможности</a>
        <a href="#" onclick="slowScroll('#products')" title="Продукты">Продукты</a>
        <a href="#" onclick="slowScroll('#career')" title="Карьера">Карьера</a>
        <a href="#" onclick="slowScroll('#contacts')" title="Контакты">Контакты</a>
        <a href="#" onclick="displayForm()" title="Вход">Вход</a>
        <a href="${pageContext.request.contextPath}/add"
           onclick="location.href='${pageContext.request.contextPath}/add'" title="Регистрация">Регистрация</a>
        <a href="${pageContext.request.contextPath}/list"
           onclick="location.href='${pageContext.request.contextPath}/list'" title="Пользователи">Пользователи</a>
    </div>
</header>
<div id="top">
    <h1>Development On The Edge</h1>
    <h3>Your source of innovative solutions</h3>
</div>
<article id="main">
    <div class="intro">
        <h2>Наши услуги помогут вам!</h2>
        <h4>Основа нашего успеха – это итерационный метод разработки и внедрения.<br><br></h4>
    </div>
    <div class="text">
        <section>
            Как правило, в начале работы над проектом, Заказчик осознает цель создания информационной системы и в общих
            чертах представляет себе задачи, которые она должна решать. Однако, заказчик не может немедленно, прямо
            сейчас, сформулировать полный перечень задач, которые он хотел бы поставить перед такой системой.<br><br>
            Заказчик тратит деньги, сопоставимые со стоимостью самого программного обеспечения на так называемые
            проектные работы, которые сами по себе занимают достаточный период. По итогам таких работ, заказчик выбирает
            готовое ПО или разработчика, который требует сформулированное техническое задание. Задание тоже приходится
            сформировать. Это еще одна статья затрат.<br><br>
            После этого определяется стоимость работ по разработке, развертыванию и внедрению программного обеспечения.
            Как правило, такие комплексы оцениваются как сумма стоимости серверной части, плюс стоимость каждого
            рабочего места. После этого разработчик приступает к работе.<br><br>
            Любой ответственный человек согласится, что разработать или даже настроить готовое ПО для нужд определенного
            заказчика — длительный, трудоемкий и затратный процесс. Беда в том, что в период, когда составлялось
            Техническое задание, разрабатывался продукт, жизнь не стояла на месте. И, как правило, уже в первый месяц
            эксплуатации системы требуются новые доработки, изменения и новые исследования.<br><br>
            Наша компания предлагает опробованный жизнью и успешно зарекомендовавший себя метод постепенных итераций. Мы
            не разделяем исследования, разработку, внедрение и эксплуатацию. Мы запускаем все одновременно.
        </section>
    </div>
</article>

<article id="products">
    <h2>Продукты</h2>
    <h4>Bean Explorer</h4>
    <div class="image">
        <img alt="BE_logo" height="46" src="images/BE_logo.png" width="219"/>
    </div>
    <section><strong>BeanExplorer</strong> — созданная нами технология для автоматической генерации интерактивных
        пользовательских
        интерфейсов и публикации данных в различном виде. Она помогает нашим разработчикам быстро и с минимальными
        затратами создавать надежные, высокопроизводительные приложения любого уровня и размера для эксплуатации в среде
        Microsoft Windows и Интернет.<br>
        <strong>BeanExplorer</strong> позволяет свести к нулю программирование форм пользовательского интерфейса
        (таблиц,
        диалогов, отчетных форм и т.д.) и связанных с этим сопутствующих задач: проверку введенных данных, трансформацию
        введенных данных в форматы баз данных и т.п. Используя BeanExplorer, разработчики могут полностью
        сконцентрироваться на моделировании системы и программировании бизнес логики и тем самым сократить время
        разработки на 30-40%.
    </section>
    <h4>BioUML</h4>
    <div class="image">
        <img alt="BioUML_logo" height="27" src="images/BioUML_logo.png" width="215"/>
    </div>
    <section><strong>BioUML</strong> — расширяемая открытая система на языке Java, адаптирующая подход визуального
        моделирования
        для формального описания и симуляции сложных биологических систем.
    </section>
    <h4>E-city</h4>
    <div class="image">
        <img alt="E-city_logo" height="66" src="images/E-city_logo_transparent-150x66.png" width="150"/>
    </div>
    <section><strong>E-city</strong> — продукт для сотрудников муниципальных учреждений, специалистов местных органов
        самоуправления и жителей городов, призванный решить вопросы автоматизации процесса управления муниципальным
        образованием,обеспечить прозрачность управления и реальность принятия решений, держать граждан в курсе
        происходящих событий, учитывать мнение общественности.
    </section>
    <h4>Портал "Мой Дом"</h4>
    <div class="image">
        <img alt="My_home_logo" height="72" src="images/my_home_logo.png" width="150"/>
    </div>
    <section>Единый портал <strong>ЖКХ "Мой дом"</strong> призван обеспечить защищенное и удобное для работы
        информационное
        пространство для всех потребителей жилищно-коммунальных услуг (ЖКУ), а также представителей управляющих
        компаний, ТСЖ, поставщиков коммунальных услуг.
    </section>
    <h4>ТИК "РЕГИОН"</h4>
    <div class="image">
        <img alt="Region_logo" height="53" src="images/region_logo.png" width="215"/>
    </div>
    <section>Одним из приоритетных направлений развития любого региона является создание информационной системы
        поддержки деятельности государственных органов по оказанию услуг населению. Повышение эффективности управления,
        сложный характер городских и сельских хозяйств, а также многообразие форм их развития требуют создания
        комплексной модели управления территорией. <br><strong>Территориальный информационный комплекс «Регион»</strong>
        — это
        универсальное решение, направленное на обеспечение эффективной работы и взаимодействия всех государственных
        структур Региона.
    </section>
</article>

<div id="career">
    <div class="intro">
        <h2>Карьера</h2>
        <section>Наша команда считает, что знания, опыт и идеи должны передаваться, поэтому мы протягиваем руку каждому,
            кто готов развиваться вместе с нами. Если Вы умны, талантливы и по-настоящему увлечены своим делом мы ждем
            Вас!<br><br></section>
    </div>
    <div class="text">
        <article>Приглашая на работу к нам, мы предлагаем:<br>
            <ul>
                <li>Работу над сложными и интересными проектами;
                <li>Достойную оплату труда точно в срок;
                <li>Полный соц. пакет и трудоустройство согласно ТК РФ;
                <li>Гибкий график работы и возможность совмещения с учебой;
                <li>Компенсацию расходов на транспорт;
                <li>Бесплатные обеды в офисе, а также чай, конфетки, печеньки и прочие плюшки;
                <li>Возможность ездить в сильные морозы на такси за счет компании;
                <li>Дружную, почти семейную обстановку в коллективе;
                <li>Корпоративные мероприятия: празднование красных дат календаря, дней рождений сотрудников, настольные
                    игры в офисе, походы в кафе, сауну и боулинг и многое другое, а также совместный выезд заграницу.
            </ul>
            <br>
            Работа с нами откроет для Вас новые горизонты, Вы сможете не только повысить свой профессиональный уровень,
            но и узнать, что такое биоинформатика, а также принять непосредственное участие в таких важных
            государственных проектах, как «Электронное правительство» и «Система межведомственного электронного
            взаимодействия».
        </article>
    </div>
</div>

<div id="contacts">
    <div style="text-align: center;">
        <h5>Обратная связь</h5>
    </div>
    <form id="input_form">
        <label for="name">Имя <span>*</span></label><br>
        <input id="name" name="name" placeholder="Введите имя" type="text"><br>
        <label for="email">Ваша почта <span>*</span></label><br>
        <input id="email" name="email" placeholder="Введите ваш адрес эл. почты" type="email"><br>
        <label for="message">Сообщение <span>*</span></label><br>
        <textarea id="message" name="message" placeholder="Введите ваше сообщение"></textarea><br>
        <div class="btn" id="mess_send" onclick="sendMessage()">Отправить</div>
    </form>
</div>

<div class="hide" id="hide"></div>
<div class="loginForm" id="loginForm">
    <form name="Форма авторизации" action="views/welcome.jsp">
        <input type="text" name="login" size="25"/>
        <input type="password" name="password" size=25/>
        <input type="submit" value="Войти">
        <input type="reset" value="Очистить форму">
    </form>
</div>

<footer>
    <p>Copyright by Лагунов Сергей, Левчук София</p>
    <p>Тел. +7(913)788-24-68</p>
    <p>E-mail: mr.forser@gmail.com</p>
</footer>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="script.js"></script>
</body>
</html>