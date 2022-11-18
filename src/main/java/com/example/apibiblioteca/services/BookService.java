package com.example.apibiblioteca.services;

import com.example.apibiblioteca.entities.Author;
import com.example.apibiblioteca.entities.Book;
import com.example.apibiblioteca.repositories.AuthorRepository;
import com.example.apibiblioteca.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.*;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;

    public String saveBook(Book book){
        //Set<Author> authorIterator = book.getAuthors();
        //Book book1 = book;
        //Optional<Author> author1 = null;
        //System.err.println(authorIterator);
        //for (Author author:authorIterator){
            //author1 = authorRepository.findById(author.getIdPerson());
            //book1.getAuthors().add(author1);
            //author1.getBooks().add(book1);
        //}
        bookRepository.save(book);
        return "Book Saved";
    }
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
    public List<Book> findBookByYear(Date year){
        return null;
    }
}
