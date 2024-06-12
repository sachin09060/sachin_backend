package com.excel.springboot_jwt_authentication.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.excel.springboot_jwt_authentication.dto.LoginUserDto;
import com.excel.springboot_jwt_authentication.dto.RegisterUserDto;
import com.excel.springboot_jwt_authentication.entites.User;
import com.excel.springboot_jwt_authentication.services.AuthenticationService;
import com.excel.springboot_jwt_authentication.services.JwtService;

@RequestMapping("/auth")
@RestController
public class AuthenticationController {
    private final JwtService jwtService;
    
    private final AuthenticationService authenticationService;

    public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/signup")
    public ResponseEntity<User> register(@RequestBody RegisterUserDto registerUserDto) {
        User registeredUser = authenticationService.signup(registerUserDto);

        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginUserDto loginUserDto) {
        User authenticatedUser = authenticationService.authenticate(loginUserDto);

        String jwtToken = jwtService.generateToken(authenticatedUser);

     // Create a new LoginResponse instance with token and expiration time
        LoginResponse loginResponse = new LoginResponse(jwtToken, jwtService.getExpirationTime());


        return ResponseEntity.ok(loginResponse);
    }
}
