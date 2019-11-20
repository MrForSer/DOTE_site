package ru.nstu.forser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.*;
import java.util.Date;

public class Database {

    private static final Logger log = LoggerFactory.getLogger(Database.class);
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/dote";
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "postgres";

    public List<Employee> getListOfEmployees() {
        List<Employee> employees = new ArrayList<>();
        try {
            Class.forName("org.postgresql.Driver");
            try (Connection con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
                Statement statement = con.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM employees");
                while (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    String lastName = resultSet.getString(2);
                    String firstName = resultSet.getString(3);
                    String middleName = resultSet.getString(4);
                    Date birthday = resultSet.getDate(5);
                    int salary = resultSet.getInt(6);
                    Employee employee = new Employee(id, lastName, firstName, middleName, birthday, salary);
                    employees.add(employee);
                }
                con.close();
                resultSet.close();
                statement.close();
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return employees;
    }

    public User selectUserByID(int id) {
        User user = null;
        try {
            Class.forName("org.postgresql.Driver");
            try (Connection con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {

                String sql = "SELECT * FROM users WHERE id = ?";
                try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
                    preparedStatement.setInt(1, id);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if (resultSet.next()) {
                        int userId = resultSet.getInt(1);
                        String login = resultSet.getString(2);
                        String password = resultSet.getString(3);
                        user = new User(userId, login, password);
                    }
                    resultSet.close();
                    con.close();
                }
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return user;
    }

    public User selectUserPasswordByLogin(int id) {
        User user = null;
        try {
            Class.forName("org.postgresql.Driver");
            try (Connection con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {

                String sql = "SELECT password FROM users WHERE login = ?";
                try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
                    preparedStatement.setInt(1, id);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if (resultSet.next()) {
                        int userId = resultSet.getInt(1);
                        String login = resultSet.getString(2);
                        String password = resultSet.getString(3);
                        user = new User(userId, login, password);
                    }
                    resultSet.close();
                    con.close();
                }
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return user;
    }

    public int insertNewUser(User user) {
        try {
            Class.forName("org.postgresql.Driver");
            try (Connection con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {

                String sql = "INSERT INTO users (login, password) VALUES (?, ?);";
                try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
                    preparedStatement.setString(1, user.getLogin());
                    preparedStatement.setString(2, user.getPassword());
                }
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return 0;
    }

    public int deleteUser(User user) {
        try {
            Class.forName("org.postgresql.Driver");
            try (Connection con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
                String sql = "DELETE FROM users WHERE login = ?;";
                try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
                    preparedStatement.setString(1, user.getLogin());
                }
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return 0;
    }
}