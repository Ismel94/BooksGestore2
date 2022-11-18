package com.example.apibiblioteca.entities;

import com.fasterxml.jackson.annotation.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "book")
@JsonIdentityInfo(generator = ObjectIdGenerators.UUIDGenerator.class,property = "@IdBook")
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdBook")
    private long IdBook;

    @Column(name = "name")
    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Author author;

    @ManyToMany(mappedBy = "books")
    private List<User> users = new ArrayList<>();

    @Column(name = "year")
    @Temporal(TemporalType.DATE)
    private Date year;

    @Column(name = "canttotal")
    private int cantTotal;

    @Column(name = "cantdisponible")
    private int cantDisponible;

    public Book(long idBook, String title, Author author, List<User> users, Date year, int cantTotal, int cantDisponible) {
        IdBook = idBook;
        this.title = title;
        this.author = author;
        this.users = users;
        this.year = year;
        this.cantTotal = cantTotal;
        this.cantDisponible = cantDisponible;
    }

    public Book() {
    }


    public long getIdBook() {
        return IdBook;
    }

    public void setIdBook(long idBook) {
        IdBook = idBook;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    public int getCantTotal() {
        return cantTotal;
    }

    public void setCantTotal(int cantTotal) {
        this.cantTotal = cantTotal;
    }

    public int getCantDisponible() {
        return cantDisponible;
    }

    public void setCantDisponible(int cantDisponible) {
        this.cantDisponible = cantDisponible;
    }

}
