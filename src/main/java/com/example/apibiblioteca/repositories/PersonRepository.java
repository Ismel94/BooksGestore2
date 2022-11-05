package com.example.apibiblioteca.repositories;

import com.example.apibiblioteca.entities.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PersonRepository extends CrudRepository<Book, Integer> {
}
