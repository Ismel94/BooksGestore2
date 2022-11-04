package com.example.booksgestore;

import com.example.booksgestore.entities.Autor;
import com.example.booksgestore.entities.Libro;
import com.example.booksgestore.repositories.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BooksGestoreApplication{


    public static void main(String[] args) {
        SpringApplication.run(BooksGestoreApplication.class, args);
    }


}
