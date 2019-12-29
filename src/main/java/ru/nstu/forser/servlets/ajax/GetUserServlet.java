package ru.nstu.forser.servlets.ajax;

import ru.nstu.forser.dao.UserDAO;
import ru.nstu.forser.entities.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/GetUserServlet")
public class GetUserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/plain");

        String login = request.getParameter("login").trim();

        UserDAO userDAO = new UserDAO();
        User user = userDAO.checkLogin(login);

        String greetings = "Логин доступен";
        if (user != null) {
            greetings = "Пользователь " + login + " уже существует.";
        }

        response.getWriter().write(greetings);
    }
}