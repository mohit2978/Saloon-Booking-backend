package com.magma.userService.Controller;

import com.magma.userService.Exception.UserException;
import com.magma.userService.Mapper.UserMapper;
import com.magma.userService.Payload.DTO.UserDTO;
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


    private final UserService userService;
    private final UserMapper userMapper;



    @GetMapping("/api/users/profile")
    public ResponseEntity<UserDTO> getUserFromJwtToken(
            @RequestHeader("Authorization") String jwt) throws Exception {

        User user = userService.getUserFromJwtToken(jwt);
        UserDTO userDTO=userMapper.mapToDTO(user);


        return new ResponseEntity<>(userDTO,HttpStatus.OK);
    }

    @GetMapping("/api/users/{userId}")
    public ResponseEntity<UserDTO> getUserById(
            @PathVariable Long userId
    ) throws UserException {
        User user = userService.getUserById(userId);
        if(user==null) {
            throw new UserException("User not found");
        }
        UserDTO userDTO=userMapper.mapToDTO(user);

        return new ResponseEntity<>(userDTO,HttpStatus.OK);
    }

    @GetMapping("/api/users")
    public ResponseEntity<List<User>> getUsers(
    ) throws UserException {
        List<User> users = userService.getAllUsers();

        return new ResponseEntity<>(users,HttpStatus.OK);
    }


}
