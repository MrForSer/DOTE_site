package ru.nstu.forser.servlets;


import ru.nstu.forser.dao.UserDAO;
import ru.nstu.forser.entities.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Enumeration;

public class LoginServlet extends HttpServlet {

        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {

            request.setCharacterEncoding("UTF8");

            User user = new User();
            HttpSession httpSession = request.getSession();

            user.setLogin("login");
            user.setPassword("password");

            UserDAO userDAO = new UserDAO();
            User checkedUser = userDAO.findUser(user.getLogin(), user.getPassword());
            String role = checkedUser.getRole();

            if(checkedUser != null){
                user = checkedUser;
                httpSession.setAttribute("user", user);
                if(role.equals("admin")){
                    resp.sendRedirect(request.getContextPath() + "/admin");
                } else {
                    resp.sendRedirect(request.getContextPath() + "/user");
                }
            } else {
                String error = "Пользователь не найден";
            }

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/login.jsp");
            requestDispatcher.forward(request, resp);
        }

}
