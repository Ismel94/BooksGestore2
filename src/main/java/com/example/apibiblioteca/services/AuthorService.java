package com.example.apibiblioteca.services;

import com.example.apibiblioteca.entities.Author;
import com.example.apibiblioteca.entities.Book;
import com.example.apibiblioteca.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    public String saveAuthor(Author author){
        authorRepository.save(author);
        return "Author Saved";
    }
    public String updateAuthor(Author author,long id){
        Author author1 = authorRepository.findById(id).get();
        try{
            if (author != null){
                if (author.getName()!=null)
                    author1.setName(author.getName());
            }
            authorRepository.save(author1);
        }catch (IllegalArgumentException e1){
            e1.printStackTrace();
        }catch (OptimisticLockingFailureException e2){
            e2.printStackTrace();
        }
        return "Author Update";
    }
    public Iterable<Author> listAuthors(){
        return authorRepository.findAll();
    }
    public Author getAuthorById(long id){
        try {
            Optional<Author> optionalAuthor = authorRepository.findById(id);
            if (optionalAuthor.isPresent()){
                Author author = optionalAuthor.get();
                return author;
            }
        }catch (IllegalArgumentException e1){
            e1.printStackTrace();
        }
        return null;
    }
    public String deleteAuthor(long id){
        try {
            Optional<Author> optionalAuthor = authorRepository.findById(id);
            if (optionalAuthor.isPresent()){
                authorRepository.deleteById(id);
                return "Author Deleted";
            }
        }catch (IllegalArgumentException e1){
            e1.printStackTrace();
        }
        return null;
    }
    public Iterable<Book> booksByAuthor(long id) {
        return authorRepository.findById(id).get().getBooks();
    }
}
