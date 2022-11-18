package com.example.apibiblioteca.entities;

import javax.persistence.*;

@Entity
@Table(name = "persons")
@Inheritance(strategy = InheritanceType.JOINED)
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPerson")
    private Long idPerson;
    @Column(name = "name")
    private String name;

    public Person(Long id, String name) {
        this.idPerson = id;
        this.name = name;
    }

    public Person() {
    }

    public Long getId() {
        return idPerson;
    }

    public void setId(Long id) {
        this.idPerson = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
