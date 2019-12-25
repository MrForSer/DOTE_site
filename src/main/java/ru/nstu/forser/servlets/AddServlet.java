package ru.nstu.forser.servlets;

import ru.nstu.forser.entities.User;
import ru.nstu.forser.dao.UserDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/add.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // задаем базовую кодировку, без нее будет ISO-8859-1 - русские буквы станут кракозябрами
        req.setCharacterEncoding("UTF8");

        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String role = req.getParameter("role");

        User user = new User(login, password, firstName, lastName, role);
        UserDAO userDAO = new UserDAO();
        userDAO.save(user);

        req.setAttribute("login", login);
        doGet(req, resp);
    }
}