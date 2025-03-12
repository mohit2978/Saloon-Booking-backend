package com.magma.userService.Controller;

import com.magma.userService.Exception.UserException;
import com.magma.userService.Repository.UserRepository;
import com.magma.userService.Service.UserService;
import com.magma.userService.modal.User;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    @Autowired
     private final UserService userService;

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody @Valid User user){
        User createdUser=userService.createUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @GetMapping("/getAllUsers")
    public ResponseEntity<List<User>>getAllUsers()
    {
        List<User>userList=userService.getAllUsers();
        return new ResponseEntity<>( userList,HttpStatus.OK);
    }

    @GetMapping("/getUser/{Id}")
   ResponseEntity<User> getUserById(@PathVariable("Id") Long id){

        User user=userService.getUserById(id);
        return new ResponseEntity<>(user,HttpStatus.OK);

    }
    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUser( @RequestBody User user,
                           @PathVariable Long id) throws Exception{
     User updatedUser=userService.updateUser(id,user);
     return new ResponseEntity<>(updatedUser,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id){
       userService.deleteUser(id);
       return new ResponseEntity<>("User Deleted",HttpStatus.ACCEPTED);
    }

}
