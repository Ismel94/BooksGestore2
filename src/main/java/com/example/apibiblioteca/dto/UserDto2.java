package com.example.apibiblioteca.dto;

import com.example.apibiblioteca.entities.User;

import java.io.Serializable;

/**
 * A DTO for the {@link User} entity
 */
public class UserDto2 implements Serializable {
    private Long idPerson;
    private String name;
    private String email;

    public Long getIdPerson() {
        return idPerson;
    }

    public UserDto2 setIdPerson(Long idPerson) {
        this.idPerson = idPerson;
        return this;
    }

    public UserDto2() {
    }

    public String getName() {
        return name;
    }

    public UserDto2 setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserDto2 setEmail(String email) {
        this.email = email;
        return this;
    }
}