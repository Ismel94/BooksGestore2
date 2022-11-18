package com.example.apibiblioteca.dto;

import java.io.Serializable;

/**
 * A DTO for the {@link com.example.apibiblioteca.entities.Book} entity
 */
public class BookDto1 implements Serializable {
    private long IdBook;
    private String title;

    public long getIdBook() {
        return IdBook;
    }

    public BookDto1 setIdBook(long IdBook) {
        this.IdBook = IdBook;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public BookDto1 setTitle(String title) {
        this.title = title;
        return this;
    }
}