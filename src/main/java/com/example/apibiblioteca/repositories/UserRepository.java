package com.example.apibiblioteca.repositories;

import com.example.apibiblioteca.entities.Book;
import com.example.apibiblioteca.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
