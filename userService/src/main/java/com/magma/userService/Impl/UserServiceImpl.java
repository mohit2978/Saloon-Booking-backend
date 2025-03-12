package com.magma.userService.Impl;

import com.magma.userService.Exception.UserException;
import com.magma.userService.Repository.UserRepository;
import com.magma.userService.Service.UserService;
import com.magma.userService.modal.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) {
        Optional<User> user= userRepository.findById(id);
        if(user.isPresent()){
            return user.get();
        }
        throw new RuntimeException("User Not Found");
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUser(Long id) {
        Optional<User>user= userRepository.findById(id);
        if(user.isEmpty()){
            throw new RuntimeException("User Not Found");
        }
        userRepository.deleteById(id);
    }

    @Override
    public User updateUser(Long id, User user) throws UserException {
        Optional<User>user1= userRepository.findById(id);
        if(user1.isEmpty()){
            throw new UserException("User Not Found");
        }
        User existingUser= user1.get();
        existingUser.setRole(user.getRole());
        existingUser.setUserName(user.getUserName());
        existingUser.setPhone(user.getPhone());
        existingUser.setEmail(user.getEmail());
        return userRepository.save(existingUser);
    }
}
