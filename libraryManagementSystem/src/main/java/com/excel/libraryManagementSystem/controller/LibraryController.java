package com.excel.libraryManagementSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.excel.libraryManagementSystem.constant.BookConstants;
import com.excel.libraryManagementSystem.constant.ContactUsConstant;
import com.excel.libraryManagementSystem.constant.UserConstants;
import com.excel.libraryManagementSystem.dto.AdminDto;
import com.excel.libraryManagementSystem.dto.BookDto;
import com.excel.libraryManagementSystem.dto.BookHistoryDto;
import com.excel.libraryManagementSystem.dto.ContactDto;
import com.excel.libraryManagementSystem.dto.EmailRequestDto;
import com.excel.libraryManagementSystem.dto.UserDto;
import com.excel.libraryManagementSystem.enums.Genre;
import com.excel.libraryManagementSystem.response.CommonResponse;
import com.excel.libraryManagementSystem.service.LibraryService;

import org.springframework.web.bind.annotation.RequestParam;

import static com.excel.libraryManagementSystem.constant.UserConstants.USER_ADDED_SUCCESS;
import static com.excel.libraryManagementSystem.constant.UserConstants.USER_UPDATED_SUCCESS;
import static com.excel.libraryManagementSystem.constant.UserConstants.GET_USER;
import static com.excel.libraryManagementSystem.constant.BookConstants.BOOK_ADDED_SUCCESS;
import static com.excel.libraryManagementSystem.constant.BookConstants.GET_BOOK;
import static com.excel.libraryManagementSystem.constant.BookHistoryConstants.BOOKHISTORY_ADDED_SUCCESS;
import static com.excel.libraryManagementSystem.constant.BookHistoryConstants.ALL_BOOK_HISTORIES;
import static com.excel.libraryManagementSystem.constant.ContactUsConstant.CONTACTUS_MESSAGE_ADDED_SUCCESS;
import static com.excel.libraryManagementSystem.constant.ContactUsConstant.GET_REQUEST;
import static com.excel.libraryManagementSystem.constant.UserConstants.ADMIN_ADDED_SUCCESS;

@RestController
@CrossOrigin
@RequestMapping(path = "/api")
public class LibraryController {
	@Autowired
	private LibraryService libraryService;

//	Add User_______________________________________________________________________________________________________________

	@PostMapping(path = "/user/add")
	public ResponseEntity<CommonResponse<String>> addUserInfo(@RequestBody UserDto userDto) {
		String email = libraryService.addUserInfo(userDto);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(CommonResponse.<String>builder().data(email).isError(false).message(USER_ADDED_SUCCESS).build());
	}
//	_______________________________________________________________________________________________________________________

//	Add Book_______________________________________________________________________________________________________________

	@PostMapping(path = "/book/add")
	public ResponseEntity<CommonResponse<String>> addBookInfo(@RequestBody BookDto bookDto) {
		String bookId = libraryService.addBookInfo(bookDto);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(CommonResponse.<String>builder().data(bookId).isError(false).message(BOOK_ADDED_SUCCESS).build());
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

//	Add ContactUs messages___________________________________________________________________________________________________
	@PostMapping(path = "/contact/add")
	public ResponseEntity<CommonResponse<String>> addContactus(@RequestBody ContactDto contactDto) {
		String contactUsMessage = libraryService.addContactUs(contactDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(CommonResponse.<String>builder().data(contactUsMessage)
				.isError(false).message(CONTACTUS_MESSAGE_ADDED_SUCCESS).build());
	}

//	Add Admin_________________________________________________________________________________________________________________
	@PostMapping(path = "/admin/add")
	public ResponseEntity<CommonResponse<String>> addAdmin(@RequestBody AdminDto adminDto) {
		String admin = libraryService.addAdmin(adminDto);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(CommonResponse.<String>builder().data(admin).isError(false).message(ADMIN_ADDED_SUCCESS).build());
	}

//	Get User_______________________________________________________________________________________________________________

	@GetMapping(path = "/user")
	public ResponseEntity<CommonResponse<List<UserDto>>> getallUsers(
			@RequestParam(name = "name", required = false) String name,
			@RequestParam(name = "email", required = false) String email,
			@RequestParam(name = "address", required = false) String address) {

		return ResponseEntity.status(HttpStatus.OK).body(CommonResponse.<List<UserDto>>builder()
				.data(libraryService.getAllUsers(name, email, address)).isError(false).message(GET_USER).build());
	}

//	Get Book_______________________________________________________________________________________________________________

	@GetMapping(path = "/book")
	public ResponseEntity<CommonResponse<List<BookDto>>> getAllBooks(
			@RequestParam(name = "bookId", required = false) String bookId,
			@RequestParam(name = "bookName", required = false) String bookName,
			@RequestParam(name = "author", required = false) String author,
			@RequestParam(name = "genre", required = false) Genre genre) {

		return ResponseEntity.status(HttpStatus.OK)
				.body(CommonResponse.<List<BookDto>>builder()
						.data(libraryService.getAllBooks(bookId, bookName, author, genre)).isError(false)
						.message(GET_BOOK).build());
	}

//	Get Book History_______________________________________________________________________________________________________

	@GetMapping(path = "/history")
	public ResponseEntity<CommonResponse<List<BookHistoryDto>>> getAllHistory(
			@RequestParam(name = "email", required = false) String email,
			@RequestParam(name = "bookId", required = false) String bookId) {
		return ResponseEntity.status(HttpStatus.OK).body(CommonResponse.<List<BookHistoryDto>>builder()
				.data(libraryService.getAllHistory(email, bookId)).isError(false).message(ALL_BOOK_HISTORIES).build());
	}

//	Get All Contact us messages_____________________________________________________________________________________________
	@GetMapping(path = "/contact")
	public ResponseEntity<CommonResponse<List<ContactDto>>> getAllRequests(
			@RequestParam(name = "name", required = false) String name,
			@RequestParam(name = "contactEmail", required = false) String contactEmail) {
		return ResponseEntity.status(HttpStatus.OK).body(CommonResponse.<List<ContactDto>>builder()
				.data(libraryService.getAllRequests(name, contactEmail)).isError(false).message(GET_REQUEST).build());
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

//	Delete Message Requests_______________________________________________________________________________________________
	@DeleteMapping(path = "/contact/delete")
	public ResponseEntity<String> deleteMessageRequest(@RequestBody ContactDto contactDto) {
		libraryService.deleteMessageRequest(contactDto);
		return ResponseEntity.ok(ContactUsConstant.REQUEST_MESSAGE_DELETED_SUCCESS);
	}

//	Update User____________________________________________________________________________________________________________

	@PutMapping(path = "/user/update")
	public ResponseEntity<CommonResponse<String>> updateUser(@RequestBody UserDto userDto) {
		String email = libraryService.updateUser(userDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(
				CommonResponse.<String>builder()
				.data(email)
				.isError(false)
				.message(USER_UPDATED_SUCCESS).build());
	}

//	Update Book_____________________________________________________________________________________________________________
	@PutMapping(path = "/book/update")
	public ResponseEntity<String> updateBook(@RequestBody BookDto bookDto) {
		String bookId = libraryService.updateBook(bookDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(bookId);
	}
	
//	Update History__________________________________________________________________________________________________________

	@PutMapping(path = "/history/update")
	public ResponseEntity<Integer> updateBookHistory(@RequestBody BookHistoryDto bookHistoryDto) {
		Integer transactionId = libraryService.updateBookHistory(bookHistoryDto);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(transactionId);
	}
	
//	Update Available Books(Decrement)__________________________________________________________________________________________________
	
	@PutMapping(path = "/history/decrementAvailableBook")
	public ResponseEntity<String> decrementAvailableBook(@RequestBody BookDto bookDto) {
		String bookId = libraryService.decrementAvailableBook(bookDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(bookId);
	}
	
	
//	Update Available Books(Increment)__________________________________________________________________________________________________
	
	@PutMapping(path = "/history/incrementAvailableBook")
	public ResponseEntity<String> incrementAvailableBook(@RequestBody BookDto bookDto) {
		String bookId = libraryService.incrementAvailableBook(bookDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(bookId);
	}
	
//	User Login______________________________________________________________________________________________________________

	@PostMapping(path = "/user/login")
	public ResponseEntity<CommonResponse<UserDto>> userLogin(@RequestBody UserDto dto) {
		UserDto user = libraryService.userLogin(dto);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(
				CommonResponse.<UserDto>builder()
				.data(user)
				.isError(false)
				.message("User Login Successfully!").build());
	}

//	Admin Login_______________________________________________________________________________________________________________
	@PostMapping(path = "/admin/login")
	public ResponseEntity<CommonResponse<String>> adminLogin(@RequestBody AdminDto adminDto) {
		String adminLogin = libraryService.adminLogin(adminDto);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(CommonResponse.<String>builder().data(adminLogin)
				.isError(false).message("Admin Login Successfully!").build());
	}

//	Forget password for user___________________________________________________________________________________________________

	@PostMapping(path = "/user/forgetpassword")
	public ResponseEntity<CommonResponse<String>> forgotPassword(@RequestBody UserDto dto) {
		String update = libraryService.forgotPassword(dto);
		return ResponseEntity.status(HttpStatus.ACCEPTED)
				.body(CommonResponse.<String>builder().data(update).isError(false).message("Password Updated").build());
	}
	
//	Mail sending________________________________________________________________________________________________________________
	
    @PostMapping("/send-email")
    public void sendEmail(@RequestBody EmailRequestDto request) {
    	libraryService.sendSimpleMessage(request.getTo(), 
    			request.getSubject(), 
    			request.getText()
    			);
    }
}
