package com.excel.libraryManagementSystem.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.excel.libraryManagementSystem.constant.BookConstants;
import com.excel.libraryManagementSystem.constant.UserConstants;
import com.excel.libraryManagementSystem.dto.BookDto;
import com.excel.libraryManagementSystem.dto.BookHistoryDto;
import com.excel.libraryManagementSystem.dto.UserDto;
import com.excel.libraryManagementSystem.entity.User;
import com.excel.libraryManagementSystem.enums.Genre;
import com.excel.libraryManagementSystem.service.LibraryService;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping(path = "/api")
public class LibraryController {
	@Autowired
	private LibraryService libraryService;
	
//	Add User__________________________________________________________________________________________________________
	
	@PostMapping(path = "/user/add")
	public ResponseEntity<String> addUserInfo(@RequestBody UserDto userDto){
		String userId = libraryService.addUserInfo(userDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(userId);
	}
//	__________________________________________________________________________________________________________________
	
//	Add Book__________________________________________________________________________________________________________
	
	@PostMapping(path = "/book/add")
	public ResponseEntity<String> addBookInfo(@RequestBody BookDto bookDto) {
		String bookId = libraryService.addBookInfo(bookDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(bookId);
	}
	
//	__________________________________________________________________________________________________________________

//	Add Book History__________________________________________________________________________________________________________

	@PostMapping(path = "/history/add")
	public ResponseEntity<String> addTransactionsInfo(@RequestBody BookHistoryDto bookHistoryDto) {
		String transactionId = libraryService.addTransactionsInfo(bookHistoryDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(transactionId);
	}
	
//	__________________________________________________________________________________________________________________
	
	
//	Get User____________________________________________________________________________________________________________
	
	@GetMapping(path = "/user")
	public ResponseEntity<List<UserDto>> getallUsers(
			@RequestParam(name = "userId",required = false) String userId,
			@RequestParam(name = "name",required = false) String name,
			@RequestParam(name = "email",required = false) String email
			){
		
		return ResponseEntity.status(HttpStatus.OK).body(libraryService.getAllUsers(userId, name, email));
	}
	
//	Get Book____________________________________________________________________________________________________________
	
	@GetMapping(path = "/book")
	public ResponseEntity<List<BookDto>> getAllBooks(
			@RequestParam(name = "bookId",required = false) String bookId,
			@RequestParam(name = "bookName",required = false) String bookName,
			@RequestParam(name = "author",required = false) String author,
			@RequestParam(name = "genre",required = false) Genre genre
			) {
		
		return ResponseEntity.status(HttpStatus.OK).body(libraryService.getAllBooks(bookId, bookName, author, genre));
	}

//	Get Book History____________________________________________________________________________________________________
	
	@GetMapping(path = "/history")
	public ResponseEntity<List<BookHistoryDto>> getAllHistory(@RequestParam(name = "userId",required = false) String userId, @RequestParam(name = "bookId",required = false) String bookId){
		return ResponseEntity.status(HttpStatus.OK).body(libraryService.getAllHistory(userId,bookId));
	}
	
//	Delete User__________________________________________________________________________________________________________
	
	@DeleteMapping(path = "/user/delete")
	public ResponseEntity<String> deleteUser(@RequestBody UserDto userDto) {
		libraryService.deleteUser(userDto);
		return ResponseEntity.ok(UserConstants.USER_DELETED_SUCCESS);
	}
	
	
//	Delete Book___________________________________________________________________________________________________________
	
	@DeleteMapping(path = "/book/delete")
	public ResponseEntity<String> deleteBook(@RequestBody BookDto bookDto) {
		libraryService.deleteBook(bookDto);
		return ResponseEntity.ok(BookConstants.BOOK_DELETED_SUCCESS);
	}
	
//	Update User____________________________________________________________________________________________________________
	
	@PutMapping(path = "/user/update")
	public ResponseEntity<String> updateUser(@RequestBody UserDto userDto) {
		String userId = libraryService.updateUser(userDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(userId);
	}
	
	@PutMapping(path = "/book/update")
	public ResponseEntity<String> updateBook(@RequestBody BookDto bookDto) {
		String bookId = libraryService.updateBook(bookDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(bookId);
	}
	
}
