package com.example.booksgestore.controllers;

import com.example.booksgestore.entities.Autor;
import com.example.booksgestore.entities.Libro;
import com.example.booksgestore.repositories.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/autor")
public class AutorController {

    @Autowired
    private AutorRepository autorRepository;

    /*  ADD */
    @GetMapping(path = "/add")
    public String addAutor(){

        Autor autor1 = new Autor("Jose Marti");
        Autor autor2 = new Autor("Pedro Juan G");
        Autor autor3 = new Autor("David del Bass");

        Libro libro1 = new Libro("Carne de Perro");
        Libro libro2 = new Libro("La Edad de Oro");
        Libro libro3 = new Libro("Secretos de un Seductor");

        autor1.getLibroSet().add(libro2);
        autor2.getLibroSet().add(libro1);
        autor3.getLibroSet().add(libro3);

        autorRepository.save(autor1);
        autorRepository.save(autor2);
        autorRepository.save(autor3);
        //autorRepository.save(autor);
        return "Authors Saved!!";
    }/*..................................*/
    /* UPDATE */
    /* LIST */
    @GetMapping(path = "/all")
    public Iterable<Autor> allAutor(){
        return autorRepository.findAll();
    }/*.................................*/
}
