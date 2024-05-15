package com.excel.demo.exception.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.excel.demo.exception.EmployeeNotFoundException;

@RestControllerAdvice
public class EmployeeExceptionHandler {
	
//	@ExceptionHandler(EmployeeNotFoundException.class)
//	public ResponseEntity<String> employeeNotFound()
	
}
