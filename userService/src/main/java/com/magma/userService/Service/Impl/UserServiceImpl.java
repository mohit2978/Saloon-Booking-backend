package com.magma.userService.Service.Impl;

import com.magma.userService.Exception.UserException;
import com.magma.userService.Payload.DTO.KeycloakUserinfo;
import com.magma.userService.Repository.UserRepository;
import com.magma.userService.Service.KeyCloakUserService;
import com.magma.userService.Service.UserService;
import com.magma.userService.modal.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final KeyCloakUserService keycloakUserService;



    @Override
    public User getUserByEmail(String email) throws UserException {
        User user=userRepository.findByEmail(email);
        if(user==null){
            throw new UserException("User not found with email: "+email);
        }
        return user;
    }

    @Override
    public User getUserFromJwtToken(String jwt) throws Exception {
        KeycloakUserinfo userinfo = keycloakUserService.fetchUserProfileByJwt(jwt);
        return userRepository.findByEmail(userinfo.getEmail());
    }

    @Override
    public User getUserById(Long id) throws UserException {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

}
