package com.craftincode.startspring.dto;

public class CreateUserDto {
    private String name;
    private String login;
    private String password;
    private Integer birthYear;

    public CreateUserDto() {
    }

    public CreateUserDto(String name, String login, String password, Integer birthYear) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.birthYear = birthYear;
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
}
