package ru.nstu.forser;

public class Authorisation {

    private String login;
    private String password;

    public Authorisation() {
        login = null;
        password = null;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
