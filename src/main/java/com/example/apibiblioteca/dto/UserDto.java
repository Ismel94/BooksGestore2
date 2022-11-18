package com.example.apibiblioteca.dto;

import com.example.apibiblioteca.entities.User;

import java.io.Serializable;

/**
 * A DTO for the {@link User} entity
 */
public class UserDto implements Serializable {
    private final Long idPerson;
    private final String name;
    private final String email;

    public UserDto(Long idPerson, String name, String email) {
        this.idPerson = idPerson;
        this.name = name;
        this.email = email;
    }

    public Long getIdPerson() {
        return idPerson;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }



    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "idPerson = " + idPerson + ", " +
                "name = " + name + ", " +
                "email = " + email + ")";
    }
}