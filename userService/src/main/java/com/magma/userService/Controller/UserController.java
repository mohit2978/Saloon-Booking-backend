package com.magma.userService.Controller;

import com.magma.userService.Repository.UserRepository;
import com.magma.userService.modal.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @PostMapping("/create")
    User createUser(@RequestBody User user){
        return userRepository.save(user);
    }
}
