package com.example.apibiblioteca.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "author")
public class Author extends Person{
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Book book;
    public Author(Long id,String name) {
        super(id,name);
    }

    public Author() {
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Author author = (Author) o;
        return Objects.equals(book, author.book);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), book);
    }

    @Override
    public String toString() {
        return "Author{" +
                "book=" + book +
                '}';
    }
}
