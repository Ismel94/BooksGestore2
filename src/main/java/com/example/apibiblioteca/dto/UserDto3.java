package com.example.apibiblioteca.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * A DTO for the {@link com.example.apibiblioteca.entities.User} entity
 */
public class UserDto3 implements Serializable {
    private Long idPerson;
    private String name;
    private String email;
    private List<BookDto1> books = new ArrayList<>();

    public Long getIdPerson() {
        return idPerson;
    }

    public UserDto3 setIdPerson(Long idPerson) {
        this.idPerson = idPerson;
        return this;
    }

    public String getName() {
        return name;
    }

    public UserDto3 setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserDto3 setEmail(String email) {
        this.email = email;
        return this;
    }

    public List<BookDto1> getBooks() {
        return books;
    }

    public UserDto3 setBooks(List<BookDto1> books) {
        this.books = books;
        return this;
    }
}