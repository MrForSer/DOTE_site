package ru.nstu.forser.jdbc;

import ru.nstu.forser.entities.User;

import java.util.List;

public interface UserDAO {

    User findUser(String login, String password);

    void insertNewUser(User user);

    List<String> getAllUserNames();
}
