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

    public List<User> getListOfUsers() {
        List<User> users = new ArrayList<>();
        try {
            Class.forName(DRIVER);
            try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
                try (Statement statement = connection.createStatement()) {
                    try (ResultSet resultSet = statement.executeQuery("SELECT login, password FROM users")) {
                        while (resultSet.next()) {
                            String login = resultSet.getString(1);
                            String password = resultSet.getString(2);
                            User user = new User(login, password);
                            users.add(user);
                        }
                    }
                }
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return users;
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
                String query = "INSERT INTO users (login, password) VALUES (?, ?);";
                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                    preparedStatement.setString(1, user.getLogin());
                    preparedStatement.setString(2, user.getPassword());
                    System.out.println("Запрос " + query + " выполнен");
                    preparedStatement.executeUpdate();
                }
            }
        } catch (Exception e) {
            System.out.println("Что-то пошло не так");
            e.getMessage();
        }
    }

    public List<String> getAllUsernames() {
        List<String> usernames = new ArrayList<>();
        try {
            Class.forName(DRIVER);
            try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
                try (Statement statement = connection.createStatement()) {
                    try (ResultSet resultSet = statement.executeQuery("SELECT firstname FROM users;")) {
                        while (resultSet.next()) {
                            String name = resultSet.getString("firstName");
                            System.out.println(name);
                            usernames.add(name);
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
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
