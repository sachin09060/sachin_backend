package com.excel.libraryManagementSystem.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.excel.libraryManagementSystem.constant.BookConstants;
import com.excel.libraryManagementSystem.constant.UserConstants;
import com.excel.libraryManagementSystem.dto.BookDto;
import com.excel.libraryManagementSystem.dto.BookHistoryDto;
import com.excel.libraryManagementSystem.dto.UserDto;
import com.excel.libraryManagementSystem.entity.Book;
import com.excel.libraryManagementSystem.entity.BookHistory;
import com.excel.libraryManagementSystem.entity.User;
import com.excel.libraryManagementSystem.enums.Genre;
import com.excel.libraryManagementSystem.exception.BookNotFoundException;
import com.excel.libraryManagementSystem.exception.UserNotFoundException;
import com.excel.libraryManagementSystem.repository.BookHistoryRepository;
import com.excel.libraryManagementSystem.repository.BookRepository;
import com.excel.libraryManagementSystem.repository.UserRepository;
import com.excel.libraryManagementSystem.service.LibraryService;
import com.excel.libraryManagementSystem.util.LibraryUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class LibraryServiceImpl implements LibraryService {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private BookHistoryRepository bookHistoryRepository;

	@Override
	public String addUserInfo(UserDto userDto) {
		User userEntity = LibraryUtils.userDtoToEntity(userDto);
		return userRepository.save(userEntity).getUserId();
	}

	@Override
	public String addBookInfo(BookDto bookDto) {
		Book bookEntity = LibraryUtils.bookDtoToEntity(bookDto);
		return bookRepository.save(bookEntity).getBookId();
	}

	@Override
	public String addTransactionsInfo(BookHistoryDto bookHistoryDto) {
		Optional<User> userOptional = userRepository.findByUserId(bookHistoryDto.getUserId());
		Optional<Book> bookOptional = bookRepository.findByBookId(bookHistoryDto.getBookId());

		if (userOptional.isPresent() && bookOptional.isPresent()) {
			User userEntity = userOptional.get();
			Book bookEntity = bookOptional.get();
			BookHistory bookHistoryEntity = LibraryUtils.bookHistoriesDtoToEntity(bookHistoryDto);

			if (userEntity.getBookHistories() != null) {
				if (!userEntity.getBookHistories().contains(bookHistoryEntity))
					userEntity.getBookHistories().add(bookHistoryEntity);
			} else {
				userEntity.setBookHistories(new ArrayList<>(Arrays.asList(bookHistoryEntity)));
			}

			if (bookEntity.getBookHistories() != null) {

				if (!bookEntity.getBookHistories().contains(bookHistoryEntity))
					bookEntity.getBookHistories().add(bookHistoryEntity);

			} else {
				bookEntity.setBookHistories(new ArrayList<>(Arrays.asList(bookHistoryEntity)));
			}
			
			bookHistoryEntity.setUser(userEntity);
			bookHistoryEntity.setBook(bookEntity);
			
			return userRepository.save(userEntity).getUserId();
		}

		return null;
	}
	
//	Get Users_____________________________________________________________________________________________________
	@Override

	
	public List<UserDto> getAllUsers(String userId, String name, String email) {
	    List<UserDto> collect = userRepository.findAll().stream()
	            .map(LibraryUtils::userEntityToDto)
	            .sorted(Comparator.comparing(UserDto::getCreatedAt).reversed())
	            .collect(Collectors.toList());

	    if (userId != null) {
	        return collect.stream()
	                .filter(u -> u.getUserId().equalsIgnoreCase(userId))
	                .collect(Collectors.toList());
	    } 
	    else if (name != null) {
	        return collect.stream()
	                .filter(u -> u.getName().equalsIgnoreCase(name))
	                .collect(Collectors.toList());
	    } 
	    else if (email != null) {
	    	return collect.stream()
	    			.filter(u -> u.getEmail().equalsIgnoreCase(email))
	    			.collect(Collectors.toList());
	    }

	    return collect;
	}
    
//    ________________________________________________________________________________________________________________

//	Get Books_________________________________________________________________________________________________________

	@Override
	public List<BookDto> getAllBooks(String bookId, String bookName, String author, Genre genre) {
	    List<BookDto> collect = bookRepository.findAll().stream().map(LibraryUtils::bookEntityToDto)
	            .sorted(Comparator.comparing(BookDto::getAddedDate).reversed())
	            .collect(Collectors.toList());

	    if (bookId != null) {
	        return collect.stream().filter(b -> b.getBookId().equalsIgnoreCase(bookId)).collect(Collectors.toList());
	    } else if (bookName != null) {
	        return collect.stream().filter(b -> b.getBookName().equalsIgnoreCase(bookName)).collect(Collectors.toList());
	    } else if (author != null) {
	        return collect.stream().filter(b -> b.getAuthor().equalsIgnoreCase(author)).collect(Collectors.toList());
	    } else if (genre != null) {
	        return collect.stream().filter(b -> b.getGenre().equals(genre)).collect(Collectors.toList());
	    }

	    return collect;
	}

	
//  ________________________________________________________________________________________________________________


	@Override
	public List<BookHistoryDto> getAllHistory(String userId, String bookId) {
		List<BookHistoryDto> collect = bookHistoryRepository.findAll().stream().map(LibraryUtils::bookHistoryEntityToDto)
		.collect(Collectors.toList());
		if(userId == null && bookId ==null) {
			return collect;
		}
//		else if(userId!= null) {
//			return collect.stream().filter(his -> his.getUserId().equals(userId)).collect(Collectors.toList());
//		}
//		
//		else if(bookId!=null) {
//			return collect.stream().filter(his -> his.getBookId().equals(bookId)).collect(Collectors.toList());
//		}
		return collect;
	}
	



	@Override
	public void deleteUser(UserDto userDto) {
		Optional<User> userOptional = userRepository.findByUserId(userDto.getUserId());
		if(userOptional.isPresent()) {
			userRepository.delete(userOptional.get());
		}else {
			throw new UserNotFoundException(UserConstants.USER_ID_NOT_FOUND);
		}
	}

	@Override
	public void deleteBook(BookDto bookDto) {
		Optional<Book> bookOptional = bookRepository.findByBookId(bookDto.getBookId());
		if(bookOptional.isPresent()) {
			bookRepository.delete(bookOptional.get());
		}else {
			throw new BookNotFoundException(BookConstants.BOOK_ID_NOT_FOUND);
		}
	}

	@Override
	public String updateUser(UserDto userDto) {
		Optional<User> userOptional = userRepository.findByUserId(userDto.getUserId());
		if(userOptional.isPresent()) {
			User user = userOptional.get();
			user.setUserId(userDto.getUserId());
			user.setName(userDto.getName());
			user.setGender(userDto.getGender());
			user.setPhone(userDto.getPhone());
			user.setEmail(userDto.getEmail());
			user.setAddress(userDto.getAddress());
			user.setIsLibrarian(userDto.getIsLibrarian());
			user.setIsUser(userDto.getIsUser());
			user.setCreatedAt(userDto.getCreatedAt());
			
			User updatedUser = userRepository.save(user);
			
			return userDto.getUserId();
		}
		return null;

	}

	@Override
	public String updateBook(BookDto bookDto) {
		Optional<Book> bookOptional = bookRepository.findByBookId(bookDto.getBookId());
		if(bookOptional.isPresent()) {
			Book book = bookOptional.get();
			book.setBookId(bookDto.getBookId());
			book.setBookName(bookDto.getBookName());
			book.setBookImgUrl(bookDto.getBookImgUrl());
			book.setAuthor(bookDto.getAuthor());
			book.setGenre(bookDto.getGenre());
			book.setDescription(bookDto.getDescription());
			book.setAddedDate(bookDto.getAddedDate());
			book.setTotalCopies(bookDto.getTotalCopies());
			book.setAvailableCopies(bookDto.getAvailableCopies());
			
			Book updatedBook = bookRepository.save(book);
			
			return bookDto.getBookId();
		}
		return null;
	}
}
