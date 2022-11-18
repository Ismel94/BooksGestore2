package com.example.apibiblioteca.services;

import com.example.apibiblioteca.entities.Author;
import com.example.apibiblioteca.entities.Book;
import com.example.apibiblioteca.repositories.AuthorRepository;
import com.example.apibiblioteca.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;

    // CREAR LIBRO
    public String saveBook(Book book){
        bookRepository.save(book);
        return "Book Saved";
    }
    // ACTUALIZAR LIBRO
    public String updateBook(Book book,long id){
        Book book1 = bookRepository.findById(id).get();
        try{
            if (book1 != null){
                if (book.getTitle()!=null)
                    book1.setTitle(book.getTitle());
                if (book.getYear()!=null)
                    book1.setYear(book.getYear());
                if (book.getCantTotal() >= 0)
                    book1.setCantTotal(book.getCantTotal());
                if (book.getCantDisponible() >= 0)
                    book1.setCantDisponible(book.getCantDisponible());
                //if (book.getAuthors().size() > 0)
                  //  book1.setAuthors(book.getAuthors());
            }
            bookRepository.save(book1);
        }catch (IllegalArgumentException e1){
            e1.printStackTrace();
        }catch (OptimisticLockingFailureException e2){
            e2.printStackTrace();
        }
        return "Book Update";
    }
    // LISTAR LIBRO
    public Iterable<Book> listBooks(){
        return bookRepository.findAll();
    }
    // OBTENER UN LIBRO
    public Book getBookById(long id){
        try {
            Optional<Book> optionalBook = bookRepository.findById(id);
            if (optionalBook.isPresent()){
                Book book = optionalBook.get();
                return book;
            }
        }catch (IllegalArgumentException e1){
            e1.printStackTrace();
        }
        return null;
    }
    // ELIMINAR LIBRO
    public String deleteBook(long id){
        try {
            Optional<Book> optionalBook = bookRepository.findById(id);
            if (optionalBook.isPresent()){
                bookRepository.deleteById(id);
                return "Book Deleted";
            }
        }catch (IllegalArgumentException e1){
            e1.printStackTrace();
        }
        return null;
    }
    // LISTAR LIBROS POR YEAR
    public List<Book> findAllByYear(Date year){
        return bookRepository.findAllByYear(year);
    }
}
