package com.excel.springboot_jwt_authentication.services;

import com.excel.springboot_jwt_authentication.dto.LoginUserDto;
import com.excel.springboot_jwt_authentication.dto.RegisterUserDto;
import com.excel.springboot_jwt_authentication.entites.User;

public interface AuthenticationService {

    User signup(RegisterUserDto input);

    User authenticate(LoginUserDto input);
}
