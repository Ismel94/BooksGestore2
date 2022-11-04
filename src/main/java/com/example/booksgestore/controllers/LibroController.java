package com.example.booksgestore.controllers;

import com.example.booksgestore.entities.Libro;
import com.example.booksgestore.repositories.AutorRepository;
import com.example.booksgestore.repositories.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/libro")
public class LibroController {

    @Autowired
    private LibroRepository libroRepository;

    @Autowired
    private AutorRepository autorRepository;

    @GetMapping("/all")
    public Iterable<Libro> getAll(){
        return libroRepository.findAll();
    }
    @PostMapping(path = "/add")
    public String saveLibro(@RequestBody Libro libro){
        libroRepository.save(libro);
        return "Libro Salved!!";
    }
}
