package com.example.apibiblioteca.services;

import com.example.apibiblioteca.entities.Book;
import com.example.apibiblioteca.repositories.AuthorRepository;
import com.example.apibiblioteca.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.logging.Logger;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;

    public String saveBook(Book book){
        bookRepository.save(book);
        return "Book Saved";
    }
    public String updateBook(long id){
        Book book = new Book();
        try{
            Optional<Book> optionalBook = bookRepository.findById(id);
            if (optionalBook.isPresent()){
                Book book1 = optionalBook.get();
                if (book1.getTitle()!=null)
                    book.setTitle(book1.getTitle());
                if (book1.getYear()!=null)
                    book.setYear(book1.getYear());
                if (book1.getCantTotal() >= 0)
                    book.setCantTotal(book1.getCantTotal());
                if (book1.getCantDisponible() >= 0)
                    book.setCantDisponible(book1.getCantDisponible());
                if (book1.getAutores().size() > 0)
                    book.setAutores(book1.getAutores());
            }
            bookRepository.save(book);
        }catch (IllegalArgumentException e1){
            e1.printStackTrace();
        }catch (OptimisticLockingFailureException e2){
            e2.printStackTrace();
        }
        return "Book Update";
    }
    public Iterable<Book> listBooks(){
        return bookRepository.findAll();
    }
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
    public Set<Book> listBookByYear(Data year){
        return bookRepository.findByYearContaining(year);
    }
    public String prestarBook(long idBook, long idAuthor){
        return null;
    }

}
