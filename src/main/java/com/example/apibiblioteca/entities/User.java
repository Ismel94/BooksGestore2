package com.example.apibiblioteca.entities;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "users")
@PrimaryKeyJoinColumn(referencedColumnName = "idPerson")
@JsonIdentityInfo(generator = ObjectIdGenerators.UUIDGenerator.class,property = "@idPerson")
public class User extends Person implements Serializable {

    @Column(name = "email")
    private String email;

    @ManyToMany()
    @JoinTable(name = "books_users",joinColumns = {@JoinColumn(name = "idPerson")}, inverseJoinColumns = {@JoinColumn(name = "IdBook")})
    private List<Book> books = new ArrayList<>();

    public User() {
    }

    public User(Long id, String name, String email, List<Book> books) {
        super(id, name);
        this.email = email;
        this.books = books;
    }

    public User(String email, List<Book> books) {
        this.email = email;
        this.books = books;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
