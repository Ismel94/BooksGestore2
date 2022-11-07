package com.example.apibiblioteca.services;

import com.example.apibiblioteca.entities.User;
import com.example.apibiblioteca.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public String saveUser(User user){
        userRepository.save(user);
        return "User Saved";
    }
    public String updateUser(long id){
        User user = new User();
        try{
            Optional<User> optionalUser = userRepository.findById(id);
            if (optionalUser.isPresent()){
                User user1 = optionalUser.get();
                if (user1.getName()!=null)
                    user.setName(user1.getName());
            }
            userRepository.save(user);
        }catch (IllegalArgumentException e1){
            e1.printStackTrace();
        }catch (OptimisticLockingFailureException e2){
            e2.printStackTrace();
        }
        return "User Update";
    }
    public Iterable<User> listUsers(){
        return userRepository.findAll();
    }
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
}
