package com.excel.libraryManagementSystem.exception.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.excel.libraryManagementSystem.exception.UserAlreadyPresentException;

@RestControllerAdvice
public class UserExceptionHandler {
	
	@ExceptionHandler(UserAlreadyPresentException.class)
	public ResponseEntity<String> userAlreadyPresentExceptionHandler(RuntimeException exception){
		return ResponseEntity.ok(exception.getMessage());
	}
}
