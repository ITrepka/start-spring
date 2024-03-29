package com.craftincode.startspring.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.OffsetDateTime;

public class User {
    private String name;
    private String login;
    private String password;
    private Integer birthYear;
    private Integer id;
    @DateTimeFormat(pattern = "YYYY-mm-DD")
    private OffsetDateTime createdAt;
    @DateTimeFormat(pattern = "YYYY-mm-DD")
    private OffsetDateTime updatedAt;

    public User(Integer id, String name, String login, String password, Integer birthYear, OffsetDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.password = password;
        this.birthYear = birthYear;
        this.createdAt = createdAt;
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

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(OffsetDateTime updatedAt) {
        this.updatedAt = updatedAt;
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
