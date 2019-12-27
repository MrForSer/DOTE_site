package ru.nstu.forser.servlets;

import ru.nstu.forser.dao.EmployeeDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class SearchByProfessionForm extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        EmployeeDAO employeeDAO = new EmployeeDAO();

        List<String> professions = employeeDAO.getAllProfessions();
        req.setAttribute("professions", professions);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("user/searchByProfession.jsp");
        requestDispatcher.forward(req, resp);
    }
}
