package com.example.apibiblioteca.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "user")
public class User extends Person{

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private Set<Book> books = new HashSet<>();

    public User(Long id, String name) {
        super(id, name);
    }

    public User() {
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
        for (Book book: books){
            book.setUser(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        User user = (User) o;
        return Objects.equals(books, user.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), books);
    }

    @Override
    public String toString() {
        return "User{" +
                "books=" + books +
                '}';
    }
}
