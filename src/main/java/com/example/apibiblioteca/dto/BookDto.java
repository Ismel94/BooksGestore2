package com.example.apibiblioteca.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * A DTO for the {@link com.example.apibiblioteca.entities.Book} entity
 */
public class BookDto implements Serializable {
    private final long IdBook;
    private final String title;
    private final Date year;
    private final int cantTotal;
    private final int cantDisponible;

    public BookDto(long idBook, String title, Date year, int cantTotal, int cantDisponible) {
        IdBook = idBook;
        this.title = title;
        this.year = year;
        this.cantTotal = cantTotal;
        this.cantDisponible = cantDisponible;
    }

    public long getIdBook() {
        return IdBook;
    }

    public String getTitle() {
        return title;
    }

    public Date getYear() {
        return year;
    }

    public int getCantTotal() {
        return cantTotal;
    }

    public int getCantDisponible() {
        return cantDisponible;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "IdBook = " + IdBook + ", " +
                "title = " + title + ", " +
                "year = " + year + ", " +
                "cantTotal = " + cantTotal + ", " +
                "cantDisponible = " + cantDisponible + ")";
    }
}