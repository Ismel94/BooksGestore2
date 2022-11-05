package com.example.apibiblioteca.repositories;

import com.example.apibiblioteca.entities.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {
}
