package com.craftincode.startspring.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.OffsetDateTime;

public class UserDto {
    private String name;
    private String login;
    private Integer birthYear;
    private Integer id;
    @DateTimeFormat(pattern = "YYYY-mm-DD")
    private OffsetDateTime createdAt;
    @DateTimeFormat(pattern = "YYYY-mm-DD")
    private OffsetDateTime updatedAt;

    public UserDto() {
    }

    public UserDto(String name, String login, Integer birthYear, Integer id, OffsetDateTime createdAt, OffsetDateTime updatedAt) {
        this.name = name;
        this.login = login;
        this.birthYear = birthYear;
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
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

    public Integer getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(Integer birthYear) {
        this.birthYear = birthYear;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
}
