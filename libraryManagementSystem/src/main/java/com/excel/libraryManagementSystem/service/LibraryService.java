package com.excel.libraryManagementSystem.service;

import java.util.List;
import java.util.Optional;

import com.excel.libraryManagementSystem.dto.BookDto;
import com.excel.libraryManagementSystem.dto.BookHistoryDto;
import com.excel.libraryManagementSystem.dto.UserDto;
import com.excel.libraryManagementSystem.entity.User;

public interface LibraryService {

	String addUserInfo(UserDto userDto);

	String addBookInfo(BookDto bookDto);

	String addTransactionsInfo(BookHistoryDto bookHistoryDto);

	List<UserDto> getAllUsers();

	UserDto getUserByUserId(String userId);

	List<BookDto> getAllBooks();

	BookDto getBookByBookId(String bookId);

}
