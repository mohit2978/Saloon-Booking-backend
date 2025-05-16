package com.magma.userService.Service;

import com.magma.userService.Payload.DTO.SignupDto;
import com.magma.userService.Payload.Response.AuthResponse;

public interface AuthService {

    AuthResponse login(String username, String password) throws Exception;

    AuthResponse signup(SignupDto req) throws Exception;

    AuthResponse getAccessTokenFromRefreshToken(String refreshToken) throws Exception;
}
