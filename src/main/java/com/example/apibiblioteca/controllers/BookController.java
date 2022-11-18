package com.example.apibiblioteca.controllers;

import com.example.apibiblioteca.entities.Book;
import com.example.apibiblioteca.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.Set;

@RestController
@RequestMapping(path = "api/books")
public class BookController {
    @Autowired
    private BookService bookService;
    // add
    @PostMapping(value = "/add")
    public String saveBook(@RequestBody Book book){
        return bookService.saveBook(book);
    }
    // update
    @PutMapping(value = "/update/{id}")
    public String updateBook(@RequestBody Book book,@PathVariable long id){
        return bookService.updateBook(book,id);
    }

    // get list book
    @GetMapping(path = "/listBooks")
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
    public Iterable<Book> findByAllDataBetween(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date year){
        return bookService.findBookByYear(year);
    }

}
