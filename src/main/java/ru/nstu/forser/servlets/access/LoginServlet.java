package ru.nstu.forser.servlets.access;


import ru.nstu.forser.dao.UserDAO;
import ru.nstu.forser.entities.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDAO userDAO = new UserDAO();
        req.setCharacterEncoding("UTF-8");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        HttpSession session = req.getSession();
        User user = userDAO.findUser(login, password);

        if (user != null) {
            session.setAttribute("userBean", user);
            session.setAttribute("Name", user.getFirstName() + " " + user.getLastName());
            if (user.getRole().equals("admin")) {
                resp.sendRedirect(req.getContextPath() + "/admin/admin.jsp");
            } else {
                resp.sendRedirect(req.getContextPath() + "/user/user.jsp");
            }
        } else {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher(req.getContextPath() + "/views/notFound.jsp");
            requestDispatcher.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
