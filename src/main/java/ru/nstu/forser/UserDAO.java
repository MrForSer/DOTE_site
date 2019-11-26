package ru.nstu.forser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.*;
import java.util.Date;

//https://www.youtube.com/watch?v=Ylo4mkqsO4w
public class UserDAO {

    private static final Logger log = LoggerFactory.getLogger(UserDAO.class);
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/dote";
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "postgres";

    public User selectUserByID(int id) {
        User user = null;
        try {
            //Class.forName("org.postgresql.Driver");
            try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {

                String query = "SELECT * FROM users WHERE id = ?";
                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                    preparedStatement.setInt(1, id);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if (resultSet.next()) {
                        int userId = resultSet.getInt(1);
                        String login = resultSet.getString(2);
                        String password = resultSet.getString(3);
                        user = new User(userId, login, password);
                    }
                    resultSet.close();
                }
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return user;
    }

    public List<Employee> getListOfEmployees() {
        List<Employee> employees = new ArrayList<>();
        try {
            //Class.forName("org.postgresql.Driver");
            try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
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
                resultSet.close();
                statement.close();
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return employees;
    }

    public User selectUserPasswordByLogin(int id) {
        User user = null;
        try {
            //Class.forName("org.postgresql.Driver");
            try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {

                String query = "SELECT password FROM users WHERE username = ?";
                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                    preparedStatement.setInt(1, id);
                    try (ResultSet resultSet = preparedStatement.executeQuery()) {
                        if (resultSet.next()) {
                            int userId = resultSet.getInt(1);
                            String login = resultSet.getString(2);
                            String password = resultSet.getString(3);
                            user = new User(userId, login, password);
                        }
                    }
                }
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return user;
    }

    public int insertNewUser(User user) {
        try {
            //Class.forName("org.postgresql.Driver");
            try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {

                String query = "INSERT INTO users (username, password) VALUES (?, ?);";
                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
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
            //Class.forName("org.postgresql.Driver");
            try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
                String query = "DELETE FROM users WHERE username = ?;";
                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                    preparedStatement.setString(1, user.getLogin());
                }
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return 0;
    }
}