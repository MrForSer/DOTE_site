package ru.nstu.forser.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.nstu.forser.DatabaseAccess;
import ru.nstu.forser.jdbc.entity.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmployeeBeanImpl implements EmployeeBean {

    private static final Logger log = LoggerFactory.getLogger(DatabaseAccess.class);
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/dote";
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "postgres";

    public List<ru.nstu.forser.Employee> getListOfEmployees() {
        List<ru.nstu.forser.Employee> employees = new ArrayList<>();
        try {
            Class.forName("org.postgresql.Driver");
            try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM employees");
                while (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    String lastName = resultSet.getString(2);
                    String firstName = resultSet.getString(3);
                    String middleName = resultSet.getString(4);
                    Date birthday = resultSet.getDate(5);
                    int salary = resultSet.getInt(6);
                    ru.nstu.forser.Employee employee = new ru.nstu.forser.Employee(id, lastName, firstName, middleName, birthday, salary);
                    employees.add(employee);
                }
                connection.close();
                resultSet.close();
                statement.close();
            }
        } catch (SQLException | ClassNotFoundException e) {
            log.error(e.getMessage());
        }
        return employees;
    }

    @Override
    public List<Employee> getEmployees() {
        return null;
    }
}
