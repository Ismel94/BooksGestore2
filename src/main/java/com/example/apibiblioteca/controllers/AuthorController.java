package com.example.apibiblioteca.controllers;

import com.example.apibiblioteca.entities.Author;
import com.example.apibiblioteca.entities.Book;
import com.example.apibiblioteca.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping(path = "/api/authors")
public class AuthorController {
    @Autowired
    private AuthorService authorService;
    // add
    @PostMapping(value = "/add")
    public String saveAuthor(@RequestBody Author author){
        return authorService.saveAuthor(author);
    }
    // update
    @PutMapping(value = "/update/{id}")
    public String updateAuthor(@RequestBody Author author, @PathVariable long id){
        return authorService.updateAuthor(author,id);
    }

    // get list author
    @GetMapping(path = "/listAuthors")
    public Iterable<Author> listAuthors(){
        return authorService.listAuthors();
    }
    // get by id
    @GetMapping(value = "/get/{id}")
    public Author getAuthor(@PathVariable long id){
        return authorService.getAuthorById(id);
    }
    // delete author
    @DeleteMapping(value = "/delete/{id}")
    public String deleteAuthor(@PathVariable long id){
        return authorService.deleteAuthor(id);
    }
    // list books by author
    @GetMapping(value = "/booksByAuthor/{id}")
    public Iterable<Book> booksByAuthor(@PathVariable long id){
        return authorService.booksByAuthor(id);
    }

}
