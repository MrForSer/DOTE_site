package ru.nstu.forser.servlets.search;

import ru.nstu.forser.dao.EmployeeDAO;
import ru.nstu.forser.entities.Employee;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class DepartmentSearchServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");

        String department = request.getParameter("department");

        EmployeeDAO employeeDAO = new EmployeeDAO();
        List<Employee> employeeList = employeeDAO.findAllEmpByDepartment(department);

        request.setAttribute("employees", employeeList);

        String nextJSP = "/user/viewSearch.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(request, response);
    }
}