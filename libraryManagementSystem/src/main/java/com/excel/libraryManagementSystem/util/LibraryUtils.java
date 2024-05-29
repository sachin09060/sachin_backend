package com.excel.libraryManagementSystem.util;

import com.excel.libraryManagementSystem.dto.BookDto;
import com.excel.libraryManagementSystem.dto.BookHistoryDto;
import com.excel.libraryManagementSystem.dto.ContactDto;
import com.excel.libraryManagementSystem.dto.UserDto;
import com.excel.libraryManagementSystem.entity.Book;
import com.excel.libraryManagementSystem.entity.BookHistory;
import com.excel.libraryManagementSystem.entity.Contact;
import com.excel.libraryManagementSystem.entity.User;

public class LibraryUtils {
	
//	User Dto to Entity_____________________________________________________________________________________________
	
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
	
//	User Entity to Dto______________________________________________________________________________________________
	
	public static UserDto userEntityToDto(User userEntity) {
		return UserDto.builder()
				.userId(userEntity.getUserId())
				.name(userEntity.getName())
				.gender(userEntity.getGender())
				.phone(userEntity.getPhone())
				.email(userEntity.getEmail())
				.address(userEntity.getAddress())
				.isLibrarian(userEntity.getIsLibrarian())
				.isUser(userEntity.getIsUser())
				.createdAt(userEntity.getCreatedAt())
				.build();
	}
	
//	Book Dto to Entity______________________________________________________________________________________________
	
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
	
//	Book Entity to Dto______________________________________________________________________________________________
	
	public static BookDto bookEntityToDto(Book bookEntity) {
		return BookDto.builder()
				.bookId(bookEntity.getBookId())
				.bookImgUrl(bookEntity.getBookImgUrl())
				.bookName(bookEntity.getBookName())
				.author(bookEntity.getAuthor())
				.genre(bookEntity.getGenre())
				.description(bookEntity.getDescription())
				.addedDate(bookEntity.getAddedDate())
				.totalCopies(bookEntity.getTotalCopies())
				.availableCopies(bookEntity.getAvailableCopies())
				.build();
	}
	
//	Book History Dto to Entity______________________________________________________________________________________
	
	public static BookHistory bookHistoriesDtoToEntity(BookHistoryDto bookHistoryDto){
		return BookHistory.builder()
				.issuedDate(bookHistoryDto.getIssuedDate())
				.dueDate(bookHistoryDto.getDueDate())
				.returnDate(bookHistoryDto.getReturnDate())
				.returned(bookHistoryDto.getReturned())
				.renewed(bookHistoryDto.getRenewed())
				.build();
	}
	
//	Book History Entity to Dto______________________________________________________________________________________
	
	public static BookHistoryDto bookHistoryEntityToDto(BookHistory bookHistoryEntity) {
		return BookHistoryDto.builder()
				.userId(bookHistoryEntity.getUser().getUserId())
				.bookId(bookHistoryEntity.getBook().getBookId())
				.issuedDate(bookHistoryEntity.getIssuedDate())
				.dueDate(bookHistoryEntity.getDueDate())
				.returnDate(bookHistoryEntity.getReturnDate())
				.returned(bookHistoryEntity.getReturned())
				.renewed(bookHistoryEntity.getRenewed())
				.build();
	}
	
//	Contact Dto to Entity___________________________________________________________________________________________
	
	public static Contact contactDtoToEntity(ContactDto contactDto) {
		return Contact.builder()
				.name(contactDto.getName())
				.email(contactDto.getEmail())
				.message(contactDto.getMessage())
				.build();
	}
	
//	Contact Entity to Dto___________________________________________________________________________________________
	
	public static ContactDto contactEntityToDto(Contact contactEntity) {
		return ContactDto.builder()
				.name(contactEntity.getName())
				.email(contactEntity.getEmail())
				.message(contactEntity.getMessage())
				.build();
	}
}
