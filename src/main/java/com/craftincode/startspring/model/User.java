package com.craftincode.startspring.model;

public class User {
    private String name;
    private String login;
    private String password;
    private Integer birthYear;
    private Integer id;

    public User(){}

    public User(Integer id, String name, String login, String password, Integer birthYear) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.password = password;
        this.birthYear = birthYear;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Integer getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(Integer birthYear) {
        this.birthYear = birthYear;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", birthYear=" + birthYear +
                '}';
    }
}
