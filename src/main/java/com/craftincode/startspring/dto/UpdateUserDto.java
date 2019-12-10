package com.craftincode.startspring.dto;

public class UpdateUserDto {
    private String name;
    private String password;
    private Integer birthYear;

    public UpdateUserDto() {
    }

    public UpdateUserDto(String name, String password, Integer birthYear) {
        this.name = name;
        this.password = password;
        this.birthYear = birthYear;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
