package com.excel.springboot_jwt_authentication.controllers;

import static com.excel.springboot_jwt_authentication.constants.ConstMessages.USER_LOGIN;
import static com.excel.springboot_jwt_authentication.constants.ConstMessages.USER_REGISTERED;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.excel.springboot_jwt_authentication.dto.LoginUserDto;
import com.excel.springboot_jwt_authentication.dto.RegisterUserDto;
import com.excel.springboot_jwt_authentication.entites.User;
import com.excel.springboot_jwt_authentication.response.CommonResponse;
import com.excel.springboot_jwt_authentication.services.AuthenticationService;
import com.excel.springboot_jwt_authentication.services.JwtServiceImpl;

@RequestMapping("/auth")
@RestController
public class AuthenticationController {
    
    @Autowired
    private JwtServiceImpl jwtService;
    
    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/signup")
    public ResponseEntity<CommonResponse<User>> register(@RequestBody RegisterUserDto registerUserDto) {
        User registeredUser = authenticationService.signup(registerUserDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(CommonResponse.<User>builder()
                        .data(registeredUser)
                        .message(USER_REGISTERED)
                        .isError(false)
                        .build());
    }

    @PostMapping("/login")
    public ResponseEntity<CommonResponse<LoginResponse>> authenticate(@RequestBody LoginUserDto loginUserDto) {
        User authenticatedUser = authenticationService.authenticate(loginUserDto);
        String jwtToken = jwtService.generateToken(authenticatedUser);
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setFullName(authenticatedUser.getFullName());
        loginResponse.setEmail(authenticatedUser.getEmail());
        loginResponse.setToken(jwtToken);
        loginResponse.setExpiresIn(jwtService.getExpirationTime());
        return ResponseEntity.status(HttpStatus.OK)
                .body(CommonResponse.<LoginResponse>builder()
                        .data(loginResponse)
                        .message(USER_LOGIN)
                        .isError(false)
                        .build());
    }
}
