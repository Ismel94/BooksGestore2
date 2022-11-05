package com.example.apibiblioteca.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String title;

    @OneToMany(mappedBy = "book",cascade = CascadeType.ALL)
    private Set<Author> autores = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private User user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Author> getAutores() {
        return autores;
    }

    public void setAutores(Set<Author> autores) {
        this.autores = autores;
        for (Author autor : autores){
            autor.setBook(this);
        }
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id && Objects.equals(title, book.title) && Objects.equals(autores, book.autores) && Objects.equals(user, book.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, autores, user);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", autores=" + autores +
                ", user=" + user +
                '}';
    }
}
