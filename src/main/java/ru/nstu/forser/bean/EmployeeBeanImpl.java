package ru.nstu.forser.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.nstu.forser.jdbc.entity.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeBeanImpl implements EmployeeBean {

    private static final Logger log = LoggerFactory.getLogger(EmployeeBeanImpl.class);
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/dote";
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "postgres";

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
    }

    @Override
    public List<Employee> getEmployees() {
        List<Employee> returnValue = new ArrayList<>();
        try (Connection connection = getConnection()) {
            try (Statement statement = connection.createStatement()) {
                try (ResultSet resultSet = statement.executeQuery("SELECT Employee_Id, First_Name, Last_Name, Email, Phone_Number, Salary FROM EMPLOYEES")) {
                    while (resultSet.next()) {
                        returnValue.add(new Employee(resultSet));
                    }
                }
            }
        } catch (SQLException ex) {
            log.error(ex.getMessage());
        }
        return returnValue;
    }
}
