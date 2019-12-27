package ru.nstu.forser.servlets.operations;

import ru.nstu.forser.dao.EmployeeDAO;
import ru.nstu.forser.entities.Employee;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EditEmployeeServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF8");

        int employeeId = Integer.parseInt(req.getParameter("id"));

        String lastName = req.getParameter("lastName");
        String department = req.getParameter("department");
        int salary = Integer.parseInt(req.getParameter("salary"));
        int rank = Integer.parseInt(req.getParameter("rank"));
        String profession = req.getParameter("profession");


        EmployeeDAO employeeDAO = new EmployeeDAO();
        Employee employee = employeeDAO.findById(employeeId);

        employee.setLastName(lastName);
        employee.setDepartment(department);
        employee.setSalary(salary);
        employee.setRank(rank);
        employee.setProfession(profession);

        employeeDAO.update(employee);

        resp.sendRedirect(req.getContextPath() + "/adminList");
    }
}