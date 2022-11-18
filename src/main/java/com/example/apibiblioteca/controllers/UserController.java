package com.example.apibiblioteca.controllers;

import com.example.apibiblioteca.dto.UserDto;
import com.example.apibiblioteca.dto.UserDto2;
import com.example.apibiblioteca.dto.UserDto3;
import com.example.apibiblioteca.entities.User;
import com.example.apibiblioteca.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(path = "/api/users")
public class UserController {

    @Autowired
    private UserService userService;
    // add
    @PostMapping(value = "/add")
    public String saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }
    // update
    @PutMapping(value = "/update/{id}")
    public String updateUser(@RequestBody User user, @PathVariable long id){
        return userService.updateUser(user,id);
    }

    // get list user
    @GetMapping(path = "/list")
    public List<UserDto2> listUsers(){
        return userService.listUsers();
    }
    // get by id
    @GetMapping(value = "/user/{id}")
    public User getUsers(@PathVariable long id){
        return userService.getUserById(id);
    }
    // delete user
    @DeleteMapping(value = "/delete/{id}")
    public String deleteUser(@PathVariable long id){
        return userService.deleteUser(id);
    }
    // prestar book to user
    @GetMapping(value = "/loan/book/{idBook}/user/{idUser}")
    public String loanBook(@PathVariable long idBook, @PathVariable long idUser){
        return userService.loanBook(idBook,idUser);
    }
    @GetMapping(path = "/listUsersBooks")
    public List<UserDto3> listUsersBooks(){
        return userService.listUsersBooks();
    }
}
