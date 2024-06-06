package com.excel.libraryManagementSystem.service;

import java.util.List;

import com.excel.libraryManagementSystem.dto.AdminDto;
import com.excel.libraryManagementSystem.dto.BookDto;
import com.excel.libraryManagementSystem.dto.BookHistoryDto;
import com.excel.libraryManagementSystem.dto.ContactDto;
import com.excel.libraryManagementSystem.dto.UserDto;
import com.excel.libraryManagementSystem.enums.Genre;

public interface LibraryService {

	String addUserInfo(UserDto userDto);

	String addBookInfo(BookDto bookDto);

	String addTransactionsInfo(BookHistoryDto bookHistoryDto);

	List<UserDto> getAllUsers(String name, String email, String address);

	List<BookDto> getAllBooks(String bookId, String bookName, String author,  Genre genre);

	List<BookHistoryDto> getAllHistory(String email, String bookId);

	void deleteUser(UserDto userDto);

	void deleteBook(BookDto bookDto);

	String updateUser(UserDto userDto);

	String updateBook(BookDto bookDto);
	
	Integer updateBookHistory(BookHistoryDto bookHistoryDto);

	String addContactUs(ContactDto contactDto);

	List<ContactDto> getAllRequests(String name, String contactEmail);

	void deleteMessageRequest(ContactDto contactDto);

	UserDto userLogin(UserDto dto);

	String addAdmin(AdminDto adminDto);

	String adminLogin(AdminDto adminDto);

	String forgotPassword(UserDto dto);
}
