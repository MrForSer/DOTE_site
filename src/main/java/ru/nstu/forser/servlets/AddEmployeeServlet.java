package ru.nstu.forser.servlets;

import ru.nstu.forser.dao.EmployeeDAO;
import ru.nstu.forser.entities.Employee;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddEmployeeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/admin/addEmployee.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF8");

        String lastName = req.getParameter("lastName");
        String department = req.getParameter("department");
        Integer salary = Integer.parseInt(req.getParameter("salary"));
        Integer rank = Integer.parseInt(req.getParameter("rank"));

        Employee employee = new Employee(lastName, department, salary, rank);
        EmployeeDAO employeeDAO = new EmployeeDAO();
        employeeDAO.save(employee);

        req.setAttribute("lastName", lastName);
        doGet(req, resp);
    }
}