package com.excel.libraryManagementSystem.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.excel.libraryManagementSystem.dto.BookDto;
import com.excel.libraryManagementSystem.dto.BookHistoryDto;
import com.excel.libraryManagementSystem.dto.UserDto;
import com.excel.libraryManagementSystem.entity.User;
import com.excel.libraryManagementSystem.service.LibraryService;
import org.springframework.web.bind.annotation.RequestParam;


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
	
	@GetMapping(path = "/user")
	public ResponseEntity<List<UserDto>> getallUsers(){
		return ResponseEntity.status(HttpStatus.OK).body(libraryService.getAllUsers());
	}
	
	@GetMapping(path = "/user/{userId}")
	public ResponseEntity<UserDto> getUserById(@PathVariable String userId){
		UserDto userDto = libraryService.getUserByUserId(userId);
		return ResponseEntity.status(HttpStatus.OK).body(libraryService.getUserByUserId(userId));
	}
	
	@GetMapping(path = "/book")
	public ResponseEntity<List<BookDto>> getAllBooks() {
		return ResponseEntity.status(HttpStatus.OK).body(libraryService.getAllBooks());
	}
	
	@GetMapping(path = "/book/{bookId}")
	public ResponseEntity<BookDto> getbookById(@PathVariable String bookId){
		BookDto bookDto = libraryService.getBookByBookId(bookId);
		return ResponseEntity.status(HttpStatus.OK).body(libraryService.getBookByBookId(bookId));
	}
}
