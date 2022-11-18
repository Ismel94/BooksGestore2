package com.example.apibiblioteca.entities;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "authors")
@PrimaryKeyJoinColumn(referencedColumnName = "idPerson")
public class Author extends Person{

    @OneToMany(mappedBy = "author",cascade = CascadeType.ALL)
    private Set<Book> books;

    public Author(Long id, String name, Set<Book> books) {
        super(id, name);
        this.books = books;
    }

    public Author(Set<Book> books) {
        this.books = books;
    }
    public Author() {}

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}
