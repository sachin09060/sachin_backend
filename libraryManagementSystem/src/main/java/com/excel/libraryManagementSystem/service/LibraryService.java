package com.excel.libraryManagementSystem.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.excel.libraryManagementSystem.dto.BookDto;
import com.excel.libraryManagementSystem.dto.BookHistoryDto;
import com.excel.libraryManagementSystem.dto.ContactDto;
import com.excel.libraryManagementSystem.dto.UserDto;
import com.excel.libraryManagementSystem.entity.User;
import com.excel.libraryManagementSystem.enums.Genre;

public interface LibraryService {

	String addUserInfo(UserDto userDto);

	String addBookInfo(BookDto bookDto);

	String addTransactionsInfo(BookHistoryDto bookHistoryDto);

	List<UserDto> getAllUsers(String userId, String name, String email);

	List<BookDto> getAllBooks(String bookId, String bookName, String author,  Genre genre);

	List<BookHistoryDto> getAllHistory(String userId, String bookId);

	void deleteUser(UserDto userDto);

	void deleteBook(BookDto bookDto);

	String updateUser(UserDto userDto);

	String updateBook(BookDto bookDto);

	String addContactUs(ContactDto contactDto);

	List<ContactDto> getAllRequests(String name, String email);

	void deleteMessageRequest(ContactDto contactDto);

}
