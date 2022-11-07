package com.example.apibiblioteca.controllers;

import com.example.apibiblioteca.entities.Book;
import com.example.apibiblioteca.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Set;

@RestController
@RequestMapping(path = "api/books")
public class BookController {
    @Autowired
    private BookService bookService;
    // add
    @PostMapping(path = "/add")
    public String saveBook(@RequestBody Book book){
        return bookService.saveBook(book);
    }
    // update
    @PutMapping(value = "/update/{id}")
    public String updateBook(@PathVariable long id){
        return bookService.updateBook(id);
    }

    // get list book
    @GetMapping(name = "/listBooks")
    public Iterable<Book> listBooks(){
        return bookService.listBooks();
    }
    // get by id
    @GetMapping(value = "/get/{id}")
    public Book getBook(@PathVariable int id){
        return bookService.getBookById(id);
    }
    // delete book
    @DeleteMapping(value = "/delete/{id}")
    public String deleteBook(@PathVariable int id){
        return null;
    }
    // get books by author
    @GetMapping(value = "/getByAuthor/{name}")
    public Set<Book> getByAuthor(@PathVariable String name){
        return null;
    }
    // get books by year
    @GetMapping(value = "/getByYear/{year}")
    public Set<Book> getByYear(@PathVariable Date year){
        return null;
    }

    // prestar book to user
    @GetMapping(value = "/prestar/book/{id}/user/{id}")
    public String prestarBook(@PathVariable long idBook, @PathVariable long idUser){
        return null;
    }
}
