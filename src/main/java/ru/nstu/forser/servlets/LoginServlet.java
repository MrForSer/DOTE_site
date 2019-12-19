package ru.nstu.forser.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/login.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("utf-8");

//        User newUser = new User();
//
//        String login = request.getParameter("login");
//        String password = request.getParameter("password");
//        newUser.setLogin(login);
//        newUser.setPassword(password);
//
//        UserDAO userDAO = new UserDAO();
//        User verifiedUser = userDAO.findUser(newUser.getLogin(), newUser.getPassword());
//
//        response.setContentType("text/xml");
//        response.setHeader("Cache-Control", "no-cache");
//
//        if (verifiedUser != null) {
//            response.getWriter().write("found");
//            newUser = verifiedUser;
//            HttpSession session = request.getSession();
//            session.setAttribute("newUser", newUser);
//        } else {
//            response.getWriter().write("not found");
//        }


        String ololo = request.getParameter("ourForm_inp");

        response.setContentType("text/xml");
        response.setHeader("Cache-Control", "no-cache");

        if (ololo.equals("Няша")) {
            response.getWriter().write("попалась");
        } else {
            response.getWriter().write("не знаем таких");
        }


    }
}