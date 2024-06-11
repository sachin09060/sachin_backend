package com.excel.libraryManagementSystem.service;

import java.util.List;

import com.excel.libraryManagementSystem.dto.AdminDto;
import com.excel.libraryManagementSystem.dto.BookDto;
import com.excel.libraryManagementSystem.dto.BookHistoryDto;
import com.excel.libraryManagementSystem.dto.ContactDto;
import com.excel.libraryManagementSystem.dto.UserDto;
import com.excel.libraryManagementSystem.enums.Genre;

public interface LibraryService {
	
//	POST User____________________________________________________________________________________________

	String addUserInfo(UserDto userDto);

//	POST Admin___________________________________________________________________________________________
	
	String addAdmin(AdminDto adminDto);
	
//	POST Book____________________________________________________________________________________________

	String addBookInfo(BookDto bookDto);
	
//	POST Transaction History_____________________________________________________________________________

	String addTransactionsInfo(BookHistoryDto bookHistoryDto);

//	POST Contact us messages_____________________________________________________________________________
	
	String addContactUs(ContactDto contactDto);

//	GET Users____________________________________________________________________________________________
	
	List<UserDto> getAllUsers(String name, String email, String address);

//	GET Books____________________________________________________________________________________________
	
	List<BookDto> getAllBooks(String bookId, String bookName, String author,  Genre genre);

//	GET Transaction History______________________________________________________________________________
	
	List<BookHistoryDto> getAllHistory(String email, String bookId);

//	GET Contact us messages______________________________________________________________________________
	
	List<ContactDto> getAllRequests(String name, String email);

//	DELETE User__________________________________________________________________________________________
	
	void deleteUser(UserDto userDto);

//	DELETE Book__________________________________________________________________________________________
	
	void deleteBook(BookDto bookDto);

//	DELETE Contact us messages___________________________________________________________________________
	
	void deleteMessageRequest(ContactDto contactDto);

//	UPDATE User__________________________________________________________________________________________
	
	String updateUser(UserDto userDto);

//	UPDATE Book__________________________________________________________________________________________
	
	String updateBook(BookDto bookDto);
	
//	UPDATE Transaction History___________________________________________________________________________
	
	Integer updateBookHistory(BookHistoryDto bookHistoryDto);

//	User login___________________________________________________________________________________________
	
	UserDto userLogin(UserDto dto);
	
//	Admin login__________________________________________________________________________________________
	
	String adminLogin(AdminDto adminDto);

//	User forget password_________________________________________________________________________________
	
	String forgotPassword(UserDto dto);
	
//	Email sending________________________________________________________________________________________
	
	void sendSimpleMessage(String to, String subject, String text);
}
