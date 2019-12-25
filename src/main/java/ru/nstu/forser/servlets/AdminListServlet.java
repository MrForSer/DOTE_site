package ru.nstu.forser.servlets;

import ru.nstu.forser.dao.EmployeeDAO;
import ru.nstu.forser.entities.Employee;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AdminListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        EmployeeDAO employeeDAO = new EmployeeDAO();

        List<Employee> employees = employeeDAO.findAllEmployees();
        req.setAttribute("employees", employees);

//        List<String> employeesData = employees.stream()
//                .map(Employee::getEmployeeData)
//                .collect(Collectors.toList());
//        req.setAttribute("employeesData", employeesData);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/admin/adminList.jsp");
        requestDispatcher.forward(req, resp);
    }
}