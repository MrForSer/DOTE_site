package ru.nstu.forser.servlets.ajax;

import ru.nstu.forser.dao.UserDAO;
import ru.nstu.forser.entities.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/CheckUserLoginServlet")
public class CheckUserLoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/plain");

        String login = request.getParameter("login").trim();

        UserDAO userDAO = new UserDAO();
        User user = userDAO.checkLogin(login);

        String loginStatus = "Логин доступен";
        if (user != null) {
            loginStatus = "Пользователь " + login + " уже существует.";
        }

        response.getWriter().write(loginStatus);
    }
}