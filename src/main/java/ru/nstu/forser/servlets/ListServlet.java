package ru.nstu.forser.servlets;

import ru.nstu.forser.entities.User;
import ru.nstu.forser.dao.UserDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class ListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserDAO userDAO = new UserDAO();

        List<User> users = userDAO.findAll();
        List<String> userNames = users.stream()
                .map(User::getFullName)
                .collect(Collectors.toList());
        req.setAttribute("userNames", userNames);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/list.jsp");
        requestDispatcher.forward(req, resp);
    }
}