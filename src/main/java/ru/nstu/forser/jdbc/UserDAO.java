package ru.nstu.forser.jdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.nstu.forser.entities.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    private static final Logger log = LoggerFactory.getLogger(UserDAO.class);
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/dote";
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "postgres";
    private static final String DRIVER = "org.postgresql.Driver";

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
    }

    public void insertNewUser(User user) {
        try {
            Class.forName(DRIVER);
            try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
                String query = "INSERT INTO users (login, password, firstName, lastName) VALUES (?, ?, ?, ?);";
                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                    preparedStatement.setString(1, user.getLogin());
                    preparedStatement.setString(2, user.getPassword());
                    preparedStatement.setString(3, user.getFirstName());
                    preparedStatement.setString(4, user.getLastName());
                    preparedStatement.executeUpdate();
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            log.error("Произошла ошибка");
            log.error(e.getMessage());
        }
    }

    public List<String> getAllUsernames() {
        List<String> usernames = new ArrayList<>();
        try {
            Class.forName(DRIVER);
            try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
                try (Statement statement = connection.createStatement()) {
                    try (ResultSet resultSet = statement.executeQuery("SELECT firstname, lastname FROM users;")) {
                        while (resultSet.next()) {
                            String fullName = new StringBuilder().append(resultSet.getString(1)).append(" ").append(resultSet.getString(2)).toString();
                            usernames.add(fullName);
                        }
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            log.error(e.getMessage());
        }
        return usernames;
    }

    public String getUserName(String login) {
        String userName = null;
        try {
            Class.forName(DRIVER);
            try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
                String query = "SELECT firstName FROM users WHERE login = ?;";
                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                    preparedStatement.setString(1, login);
                    try (ResultSet resultSet = preparedStatement.executeQuery()) {
                        if (resultSet.next()) {
                            userName = resultSet.getString(1);
                            return userName;
                        }
                    }
                }
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return userName;
    }

    public User selectUserByName(String login) {
        User user = null;
        try {
            Class.forName(DRIVER);
            try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
                String query = "SELECT * FROM users WHERE login = ?;";
                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                    preparedStatement.setString(1, login);
                    try (ResultSet resultSet = preparedStatement.executeQuery()) {
                        if (resultSet.next()) {
                            String password = resultSet.getString(2);
                            user = new User(login, password);
                        }
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            log.error(e.getMessage());
        }
        return user;
    }

    public int deleteUser(User user) {
        try {
            Class.forName(DRIVER);
            try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
                String query = "DELETE FROM users WHERE login = ?;";
                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                    preparedStatement.setString(1, user.getLogin());
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            log.error(e.getMessage());
        }
        return 0;
    }

    public User findUser(String login, String password) {
        User user = null;
        try {
            Class.forName(DRIVER);
            try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
                String query = "SELECT 1 FROM users WHERE login = ? AND password = ?;";
                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                    preparedStatement.setString(1, login);
                    preparedStatement.setString(2, password);
                    try (ResultSet resultSet = preparedStatement.executeQuery()) {
                        if (resultSet.next()) {
                            user = new User(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5));
                            return user;
                        }
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            log.error(e.getMessage());
            return null;
        }
        return user;
    }
}
