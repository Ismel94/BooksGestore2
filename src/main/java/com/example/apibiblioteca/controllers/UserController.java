package com.example.apibiblioteca.controllers;

import com.example.apibiblioteca.entities.User;
import com.example.apibiblioteca.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Set;

@RestController
@RequestMapping(name = "/api/users")
public class UserController {

    @Autowired
    private UserService userService;
    // add
    @PostMapping(path = "/add")
    public String saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }
    // update
    @PutMapping(value = "/update/{id}")
    public String updateUser(@PathVariable long id){
        return userService.updateUser(id);
    }

    // get list user
    @GetMapping(name = "/listUsers")
    public Iterable<User> listUsers(){
        return userService.listUsers();
    }
    // get by id
    @GetMapping(value = "/get/{id}")
    public User getUsers(@PathVariable long id){
        return userService.getUserById(id);
    }
    // delete user
    @DeleteMapping(value = "/delete/{id}")
    public String deleteUser(@PathVariable long id){
        return userService.deleteUser(id);
    }

}
