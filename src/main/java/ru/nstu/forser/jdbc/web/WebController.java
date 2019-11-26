package ru.nstu.forser.jdbc.web;

import ru.nstu.forser.bean.EmployeeBeanImpl;
import ru.nstu.forser.bean.EmployeeBean;
import ru.nstu.forser.jdbc.entity.Employee;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "WebController", urlPatterns = {"/WebController"})
public class WebController extends HttpServlet {

    EmployeeBeanImpl employeeBean = new EmployeeBeanImpl();
    Gson gson = new Gson();

    private void reportError(HttpServletResponse response, String message) throws ServletException, IOException {
    }
}
