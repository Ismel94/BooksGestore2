package com.example.apibiblioteca.services;

import com.example.apibiblioteca.dto.BookDto1;
import com.example.apibiblioteca.dto.UserDto;
import com.example.apibiblioteca.dto.UserDto2;
import com.example.apibiblioteca.dto.UserDto3;
import com.example.apibiblioteca.entities.Book;
import com.example.apibiblioteca.entities.User;
import com.example.apibiblioteca.repositories.BookRepository;
import com.example.apibiblioteca.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BookRepository bookRepository;

    // CREAR USUARIO
    public String saveUser(User user){
        if (user.getName() != null && user.getEmail() != null) {
            userRepository.save(user);
            return "User Saved";
        }
        return "Los campos nombre y email deben ser validos";
    }
    // ACTUALIZAR USUARIO
    public String updateUser(User user, long id){
        //User user = new User();
        try{
            User user1 = userRepository.findById(id).get();
            if (user != null){
                if (user.getEmail()!=null)
                    user1.setEmail(user.getEmail());
            }
            userRepository.save(user1);
        }catch (IllegalArgumentException e1){
            e1.printStackTrace();
        }catch (OptimisticLockingFailureException e2){
            e2.printStackTrace();
        }
        return "User Update";
    }
    // OBTENER USUARIO
    public User getUserById(long id){
        try {
            Optional<User> optionalUser = userRepository.findById(id);
            if (optionalUser.isPresent()){
                User user = optionalUser.get();
                return user;
            }
        }catch (IllegalArgumentException e1){
            e1.printStackTrace();
        }
        return null;
    }
    // ELIMINAR USUARIO
    public String deleteUser(long id){
        try {
            Optional<User> optionalUser = userRepository.findById(id);
            if (optionalUser.isPresent()){
                userRepository.deleteById(id);
                return "User Deleted";
            }
        }catch (IllegalArgumentException e1){
            e1.printStackTrace();
        }
        return null;
    }
    // PERSTAR UN LIBRO
    public String loanBook(long idBook, long idUser){
        User user = userRepository.findById(idUser).get();
        Book book = bookRepository.findById(idBook).get();

        user.getBooks().add(book);
        userRepository.save(user);

        book.setCantDisponible(book.getCantDisponible() - 1);
        bookRepository.save(book);
        return "The Book "+book.getTitle()+"to Loan to "+user.getName();
    }
    // LISTA SOLO LOS USUARIOS
    public List<UserDto2> listUsers(){
        List<User> userIterable = (List<User>) userRepository.findAll();
        List<UserDto2> userDtos = new ArrayList<>();
        UserDto2 auxDTO;
        for (User user:userIterable){
            auxDTO = new UserDto2();
            auxDTO.setIdPerson(user.getId());
            auxDTO.setName(user.getName());
            auxDTO.setEmail(user.getEmail());

            userDtos.add(auxDTO);
        }

        return userDtos;
    }
    // ESTE LISTA LOS USUARIOS CON SUS LIBROS
    public List<UserDto3> listUsersBooks() {
        List<User> userIterable = (List<User>) userRepository.findAll();
        List<UserDto3> userDtos = new ArrayList<>();
        List<BookDto1> bookDto1List;

        UserDto3 auxDTO;
        BookDto1 auxBookDto1;
        for (User user:userIterable){
            auxDTO = new UserDto3();
            auxBookDto1 = new BookDto1();
            bookDto1List = new ArrayList<>();
            auxDTO.setIdPerson(user.getId());
            auxDTO.setName(user.getName());
            auxDTO.setEmail(user.getEmail());
            for (Book book: user.getBooks()){
                auxBookDto1.setIdBook(book.getIdBook());
                auxBookDto1.setTitle(book.getTitle());
                bookDto1List.add(auxBookDto1);
            }
            auxDTO.setBooks(bookDto1List);
            userDtos.add(auxDTO);
        }
        return userDtos;
    }
}
