package ru.nstu.forser.jdbc.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.nstu.forser.bean.EmployeeBeanImpl;
import ru.nstu.forser.bean.EmployeeBean;
import ru.nstu.forser.jdbc.entity.Employee;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.*;


@WebServlet(name = "WebController", urlPatterns = {"/WebController"})
public class WebController extends HttpServlet {

    private static final Logger log = LoggerFactory.getLogger(WebController.class);
    private EmployeeBeanImpl employeeBean = new EmployeeBeanImpl();
    private Gson gson = new Gson();

    private void reportError(HttpServletResponse response, String message) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet WebController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>" + message + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) {
        List<Employee> employeeList = null;
        employeeList = employeeBean.getEmployees();
        if (employeeList != null) {
            response.setContentType("application/json");
            try {
                gson.toJson(employeeList, new TypeToken<ArrayList<Employee>>() {
                }.getType(), response.getWriter());
            } catch (IOException e) {
                log.error(e.getMessage());
            }
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "JdbcWebServlet: Reading Employees table using JDBC and transforming it as a JSON.";
    }
}
