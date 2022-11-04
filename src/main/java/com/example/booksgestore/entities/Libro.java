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
@Table(name = "Libro")
public class Libro implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdLibro", nullable = false)
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "AutorLibro", joinColumns = {@JoinColumn(name = "IdLibro")},inverseJoinColumns = {@JoinColumn(name = "IdAutor")})
    private Set<Autor> autores = new HashSet<>();

    @JsonBackReference
    public Set<Autor> getAutorSet() {
        return autores;
    }

    public Libro(String name) {
        this.name = name;
    }

    public Libro() {
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



    public void setAutorSet(Set<Autor> autorSet) {
        this.autores = autorSet;
    }

 /*
    public void setAutorSet(Set<Autor> autorSet) {
        this.autorSet = autorSet;
        for (Autor autor1 : autorSet){
            autor1.setLibro(this);
        }
    }*/

}
