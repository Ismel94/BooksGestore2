package com.example.apibiblioteca.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String title;

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<Author> authors = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private User user;

    @Column(name = "year")
    @Temporal(TemporalType.DATE)
    private Date year;

    @Column(name = "canttotal")
    private int cantTotal;

    @Column(name = "cantdisponible")
    private int cantDisponible;

    public Book(long id, String title, Set<Author> authors, User user, Date year, int cantTotal, int cantDisponible) {
        this.id = id;
        this.title = title;
        this.authors = authors;
        this.user = user;
        this.year = year;
        this.cantTotal = cantTotal;
        this.cantDisponible = cantDisponible;
    }
    public Book() {
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Author> getAutores() {
        return authors;
    }

    public void setAutores(Set<Author> autores) {
        this.authors = autores;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public int getCantTotal() {
        return cantTotal;
    }

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id && cantTotal == book.cantTotal && cantDisponible == book.cantDisponible && Objects.equals(title, book.title) && Objects.equals(authors, book.authors) && Objects.equals(user, book.user) && Objects.equals(year, book.year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, authors, user, year, cantTotal, cantDisponible);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", autores=" + authors +
                ", user=" + user +
                ", year=" + year +
                ", cantTotal=" + cantTotal +
                ", cantDisponible=" + cantDisponible +
                '}';
    }
}
