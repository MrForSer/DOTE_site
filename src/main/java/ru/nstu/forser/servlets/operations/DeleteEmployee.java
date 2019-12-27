package ru.nstu.forser.servlets.operations;

import ru.nstu.forser.dao.EmployeeDAO;
import ru.nstu.forser.entities.Employee;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteEmployee extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");

        int employeeId = Integer.parseInt(request.getParameter("id"));
        EmployeeDAO employeeDAO = new EmployeeDAO();
        Employee employee = employeeDAO.findById(employeeId);
        employeeDAO.delete(employee);

        response.sendRedirect(request.getContextPath() + "/adminList");
    }
}
