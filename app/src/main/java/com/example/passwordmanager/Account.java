package com.example.passwordmanager;

import java.io.Serializable;

public class Account implements Serializable {
    private int id;
    private String pageName;
    private String login;
    private String password;

    public Account(int id, String pageName, String login, String password) {
        this.id = id;
        this.pageName = pageName;
        this.login = login;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return pageName;
    }
}