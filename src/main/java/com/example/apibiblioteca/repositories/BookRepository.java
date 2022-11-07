package com.example.apibiblioteca.repositories;

import com.example.apibiblioteca.entities.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.xml.crypto.Data;
import java.io.Serializable;
import java.util.Optional;
import java.util.Set;


@Repository
public interface BookRepository extends CrudRepository<Book, Serializable> {
    Optional<Book> findByName(String nameAuthor);

    Set<Book> findByYearContaining(Data year);
}
