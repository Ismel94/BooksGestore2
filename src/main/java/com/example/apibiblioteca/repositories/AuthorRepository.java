package com.example.apibiblioteca.repositories;

import com.example.apibiblioteca.entities.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends CrudRepository<Author,Integer> {
}
