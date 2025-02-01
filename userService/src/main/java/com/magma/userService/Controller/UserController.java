package com.magma.userService.Controller;

import com.magma.userService.Repository.UserRepository;
import com.magma.userService.modal.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @PostMapping("/create")
    User createUser(@RequestBody User user){
        return userRepository.save(user);
    }
    @GetMapping("/getAllUsers")
    List<User>getAllUsers(){
        return userRepository.findAll();
    }
    @GetMapping("/getUser/{Id}")
    User getUserById(@PathVariable("Id") Long id){
        Optional<User>user= userRepository.findById(id);
        if(user.isPresent()){
            return user.get();
        }
        throw new RuntimeException("User Not Found");
    }

}
