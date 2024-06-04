package com.excel.libraryManagementSystem.exception.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.excel.libraryManagementSystem.exception.PasswordMismatchException;
import com.excel.libraryManagementSystem.exception.UserAlreadyPresentException;
import com.excel.libraryManagementSystem.exception.UserNotFoundException;
import com.excel.libraryManagementSystem.response.CommonResponse;

@RestControllerAdvice
public class UserExceptionHandler {
	
	@ExceptionHandler(UserAlreadyPresentException.class)
	public ResponseEntity<CommonResponse<String>> userAlreadyPresentExceptionHandler(RuntimeException exception){
		return ResponseEntity.ok(CommonResponse.<String>builder().isError(true).message(exception.getMessage()).build());
	}
	
	@ExceptionHandler(PasswordMismatchException.class)
	public ResponseEntity<CommonResponse<String>> passwordMissmatchHandler(RuntimeException exception){
		return ResponseEntity.ok(CommonResponse.<String>builder().isError(true).message(exception.getMessage()).build());
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<CommonResponse<String>> UserNotFoundException(RuntimeException exception){
		return ResponseEntity.ok(CommonResponse.<String>builder().isError(true).message(exception.getMessage()).build());
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<CommonResponse<String>> IllegalArgumentException(RuntimeException exception){
		return ResponseEntity.ok(CommonResponse.<String>builder().isError(true).message(exception.getMessage()).build());
	}
}
