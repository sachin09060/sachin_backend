package com.excel.libraryManagementSystem.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import com.excel.libraryManagementSystem.response.CommonResponse;
import com.excel.libraryManagementSystem.service.LibraryService;
import org.springframework.web.bind.annotation.RequestParam;

import static com.excel.libraryManagementSystem.constant.UserConstants.USER_ADDED_SUCCESS;
import static com.excel.libraryManagementSystem.constant.BookConstants.BOOK_ADDED_SUCCESS;
import static com.excel.libraryManagementSystem.constant.BookHistoryConstants.BOOKHISTORY_ADDED_SUCCESS;


@RestController
@CrossOrigin
@RequestMapping(path = "/api")
public class LibraryController {
	@Autowired
	private LibraryService libraryService;
	
//	Add User_______________________________________________________________________________________________________________
	
	@PostMapping(path = "/user/add")
	public ResponseEntity<CommonResponse<String>> addUserInfo(@RequestBody UserDto userDto){
		String userId = libraryService.addUserInfo(userDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(CommonResponse.<String>builder().data(userId)
						.isError(false).message(USER_ADDED_SUCCESS).build());
	}
//	_______________________________________________________________________________________________________________________
	
//	Add Book_______________________________________________________________________________________________________________
	
	@PostMapping(path = "/book/add")
	public ResponseEntity<CommonResponse<String>> addBookInfo(@RequestBody BookDto bookDto) {
		String bookId = libraryService.addBookInfo(bookDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(CommonResponse.<String>builder().data(bookId)
				.isError(false).message(BOOK_ADDED_SUCCESS).build());
	}
	
//	_______________________________________________________________________________________________________________________

//	Add Book History_______________________________________________________________________________________________________

	@PostMapping(path = "/history/add")
	public ResponseEntity<CommonResponse<String>> addTransactionsInfo(@RequestBody BookHistoryDto bookHistoryDto) {
		String transactionId = libraryService.addTransactionsInfo(bookHistoryDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(CommonResponse.<String>builder().data(transactionId)
				.isError(false).message(BOOKHISTORY_ADDED_SUCCESS).build());
	}
	
//	_______________________________________________________________________________________________________________________
	
	
//	Get User_______________________________________________________________________________________________________________
	
	@GetMapping(path = "/user")
	public ResponseEntity<List<UserDto>> getallUsers(
			@RequestParam(name = "userId",required = false) String userId,
			@RequestParam(name = "name",required = false) String name,
			@RequestParam(name = "email",required = false) String email
			){
		
		return ResponseEntity.status(HttpStatus.OK).body(libraryService.getAllUsers(userId, name, email));
	}
	
//	Get Book_______________________________________________________________________________________________________________
	
	@GetMapping(path = "/book")
	public ResponseEntity<List<BookDto>> getAllBooks(
			@RequestParam(name = "bookId",required = false) String bookId,
			@RequestParam(name = "bookName",required = false) String bookName,
			@RequestParam(name = "author",required = false) String author,
			@RequestParam(name = "genre",required = false) Genre genre
			) {
		
		return ResponseEntity.status(HttpStatus.OK).body(libraryService.getAllBooks(bookId, bookName, author, genre));
	}

//	Get Book History_______________________________________________________________________________________________________
	
	@GetMapping(path = "/history")
	public ResponseEntity<List<BookHistoryDto>> getAllHistory(@RequestParam(name = "userId",required = false) String userId, @RequestParam(name = "bookId",required = false) String bookId){
		return ResponseEntity.status(HttpStatus.OK).body(libraryService.getAllHistory(userId,bookId));
	}
	
//	Delete User____________________________________________________________________________________________________________
	
	@DeleteMapping(path = "/user/delete")
	public ResponseEntity<String> deleteUser(@RequestBody UserDto userDto) {
		libraryService.deleteUser(userDto);
		return ResponseEntity.ok(UserConstants.USER_DELETED_SUCCESS);
	}
	
	
//	Delete Book____________________________________________________________________________________________________________
	
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
	
//	Update Book_____________________________________________________________________________________________________________
	@PutMapping(path = "/book/update")
	public ResponseEntity<String> updateBook(@RequestBody BookDto bookDto) {
		String bookId = libraryService.updateBook(bookDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(bookId);
	}
	
}
