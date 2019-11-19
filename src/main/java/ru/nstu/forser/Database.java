package ru.nstu.forser;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

    public void createUser(User user){
        //берем user.login и user.password, провер€ем, что такие еще не были зарегистрированы (приватным методом) и инстертим их в Ѕƒ
    }

    public void signIn(User user) throws SQLException {
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dote", "postgres", "postgres")) {
            try (Statement statement = connection.createStatement()) {

            }
        }
    }
/*
    public static boolean checkPassword(String login, String inputPassword){
        String realPassword = getPasswordFromDB(login);
        boolean check = false;
        if (inputPassword.equals(realPassword)){
            check = true;
        }
        return check;
    }

    private static String getPasswordFromDB(String username){
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dote", "postgres", "postgres")) {
            try (Statement statement = connection.createStatement()) {
                try (ResultSet resultSet = statement.executeQuery("SELECT * FROM users WHERE username = '" + username + "'")) {
                    while (resultSet.next()) {
                        return (resultSet.getString("password"));
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
    }

 */
}