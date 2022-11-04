package com.example.booksgestore.repositories;

import com.example.booksgestore.entities.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LibroRepository extends JpaRepository<Libro, Integer> {
}
