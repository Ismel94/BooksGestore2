package com.example.booksgestore.entities;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Autor")
public class Autor implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdAutor", nullable = false)
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "AutorLibro", joinColumns = {@JoinColumn(name = "IdAutor")},inverseJoinColumns = {@JoinColumn(name = "IdLibro")})
    private Set<Libro> libros = new HashSet<>();

    @JsonManagedReference
    public Set<Libro> getLibroSet() {
        return libros;
    }

    public Autor(String name) {
        this.name = name;
    }

    public Autor() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLibroSet(Set<Libro> libroSet) {
        this.libros = libroSet;
    }
}
