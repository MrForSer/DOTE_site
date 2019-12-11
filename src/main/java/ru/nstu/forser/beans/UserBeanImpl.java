package ru.nstu.forser.beans;

import ru.nstu.forser.entities.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserBeanImpl implements UserBean {

    private static final String DB_URL = "jdbc:postgresql://localhost:5432/dote";
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "postgres";
    private static final String DRIVER = "org.postgresql.Driver";


    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
    }

    @Override
    public List<User> getUsers() {
        List<User> returnValue = new ArrayList<>();
        try {
            Class.forName(DRIVER);
            try (Connection connection = getConnection()) {
                try (Statement statement = connection.createStatement()) {
                    try (ResultSet resultSet = statement.executeQuery("SELECT id, login, password, firstname, lastname FROM users")) {
                        while (resultSet.next()) {
                            returnValue.add(new User(
                                    resultSet.getInt(1),
                                    resultSet.getString(2),
                                    resultSet.getString(3),
                                    resultSet.getString(4),
                                    resultSet.getString(5)
                            ));
                        }
                    }
                }
            }
        } catch (SQLException | ClassNotFoundException ex) {
            ex.getMessage();
        }
        return returnValue;
    }
}