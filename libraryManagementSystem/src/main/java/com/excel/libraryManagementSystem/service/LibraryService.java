package com.excel.libraryManagementSystem.service;

import com.excel.libraryManagementSystem.dto.BookDto;
import com.excel.libraryManagementSystem.dto.BookHistoryDto;
import com.excel.libraryManagementSystem.dto.UserDto;

public interface LibraryService {

	String addUserInfo(UserDto userDto);

	String addBookInfo(BookDto bookDto);

	String addTransactionsInfo(BookHistoryDto bookHistoryDto);

}
