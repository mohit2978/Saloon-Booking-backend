package com.magma.userService.Service;

import com.magma.userService.Exception.UserException;
import com.magma.userService.modal.User;

import java.util.List;


public interface UserService {
    User getUserByEmail(String email) throws UserException;
    User getUserFromJwtToken(String jwt) throws Exception;
    User getUserById(Long id) throws UserException;
    List<User> getAllUsers();

}
