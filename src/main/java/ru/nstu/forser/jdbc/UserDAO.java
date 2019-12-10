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

    public String getUserName(String login){
        String userName = null;
        try {
            Class.forName(DRIVER);
            try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
                String query = "SELECT userName FROM users WHERE login = ?";
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

    public static User findUser(String login, String password) {
        User user = null;
        try {
            Class.forName(DRIVER);
            try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
                String query = "SELECT 1 FROM users WHERE login = ? AND password = ?";
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
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
        return user;
    }

    public User selectUserByName(String login) {
        User user = null;
        try {
            Class.forName(DRIVER);
            try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {

                String query = "SELECT * FROM users WHERE login = ?";
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
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return user;
    }

    public void insertNewUser(User user) {
        System.out.println("Попытка создать юзера");
        try {
            Class.forName(DRIVER);
            System.out.println("Драйвер получен");
            try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
                System.out.println("Выполняем запрос");
                String query = "INSERT INTO users (login, password, firstName, lastName) VALUES (?, ?, ?, ?);";
                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                    preparedStatement.setString(1, user.getLogin());
                    preparedStatement.setString(2, user.getPassword());
                    preparedStatement.setString(3, user.getFirstName());
                    preparedStatement.setString(4, user.getLastName());
                    preparedStatement.executeUpdate();
                }
            }
        } catch (Exception e) {
            log.error("Что-то пошло не так");
            log.error(e.getMessage());
        }
    }

    public List<String> getAllUsernames() {
        List<String> usernames = new ArrayList<>();
        try {
            Class.forName("org.postgresql.Driver");
            try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT firstname, lastname FROM users;");
                while (resultSet.next()) {
                    String fullName = new StringBuilder().append(resultSet.getString(1)).append(" ").append(resultSet.getString(2)).toString();
                    usernames.add(fullName);
                }
                connection.close();
                resultSet.close();
                statement.close();
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return usernames;
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
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return 0;
    }
}
