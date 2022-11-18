package com.example.apibiblioteca.repositories;

import com.example.apibiblioteca.entities.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

}
