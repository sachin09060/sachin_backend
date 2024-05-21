package com.excel.libraryManagementSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.excel.libraryManagementSystem.dto.BookDto;
import com.excel.libraryManagementSystem.dto.BookHistoryDto;
import com.excel.libraryManagementSystem.dto.UserDto;
import com.excel.libraryManagementSystem.service.LibraryService;

@RestController
@RequestMapping(path = "/api")
public class LibraryController {
	@Autowired
	private LibraryService libraryService;
	
	@PostMapping(path = "/user/add")
	public ResponseEntity<String> addUserInfo(@RequestBody UserDto userDto){
		String userId = libraryService.addUserInfo(userDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(userId);
	}
	
	@PostMapping(path = "/book/add")
	public ResponseEntity<String> addBookInfo(@RequestBody BookDto bookDto) {
		String bookId = libraryService.addBookInfo(bookDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(bookId);
	}
	
	@PostMapping(path = "/history/add")
	public ResponseEntity<String> addTransactionsInfo(@RequestBody BookHistoryDto bookHistoryDto) {
		String transactionId = libraryService.addTransactionsInfo(bookHistoryDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(transactionId);
	}
	
}
