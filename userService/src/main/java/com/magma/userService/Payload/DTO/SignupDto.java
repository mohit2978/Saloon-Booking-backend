package com.magma.userService.Payload.DTO;


import com.magma.userService.domain.UserRole;
import lombok.Data;

@Data
public class SignupDto {
    private String email;
    private String password;
    private String phone;
    private String fullName;
    private String username;
    private UserRole role;


}