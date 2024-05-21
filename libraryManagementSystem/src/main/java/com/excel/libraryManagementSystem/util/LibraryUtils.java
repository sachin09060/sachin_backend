package com.excel.libraryManagementSystem.util;

import java.util.List;
import java.util.stream.Collectors;

import com.excel.libraryManagementSystem.dto.BookDto;
import com.excel.libraryManagementSystem.dto.BookHistoryDto;
import com.excel.libraryManagementSystem.dto.UserDto;
import com.excel.libraryManagementSystem.entity.Book;
import com.excel.libraryManagementSystem.entity.BookHistory;
import com.excel.libraryManagementSystem.entity.User;

public class LibraryUtils {
	
	public static User userDtoToEntity(UserDto userDto) {
		return User.builder()
				.userId(userDto.getUserId())
				.name(userDto.getName())
				.gender(userDto.getGender())
				.phone(userDto.getPhone())
				.email(userDto.getEmail())
				.address(userDto.getAddress())
				.isLibrarian(userDto.getIsLibrarian())
				.isUser(userDto.getIsUser())
				.createdAt(userDto.getCreatedAt())
				.build();
	}
	
	public static Book bookDtoToEntity(BookDto bookDto) {
		return Book.builder()
				.bookId(bookDto.getBookId())
				.bookImgUrl(bookDto.getBookImgUrl())
				.bookName(bookDto.getBookName())
				.author(bookDto.getAuthor())
				.genre(bookDto.getGenre())
				.description(bookDto.getDescription())
				.addedDate(bookDto.getAddedDate())
				.totalCopies(bookDto.getTotalCopies())
				.availableCopies(bookDto.getAvailableCopies())
				.build();
	}
	
	public static BookHistory bookHistoriesDtoToEntity(BookHistoryDto bookHistoryDto){
		return BookHistory.builder()
				.issuedDate(bookHistoryDto.getIssuedDate())
				.dueDate(bookHistoryDto.getDueDate())
				.returnDate(bookHistoryDto.getReturnDate())
				.returned(bookHistoryDto.getReturned())
				.renewed(bookHistoryDto.getRenewed())
				.build();
	}
}
