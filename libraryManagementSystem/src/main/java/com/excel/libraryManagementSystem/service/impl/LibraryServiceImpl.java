package com.excel.libraryManagementSystem.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excel.libraryManagementSystem.dto.BookDto;
import com.excel.libraryManagementSystem.dto.BookHistoryDto;
import com.excel.libraryManagementSystem.dto.UserDto;
import com.excel.libraryManagementSystem.entity.Book;
import com.excel.libraryManagementSystem.entity.BookHistory;
import com.excel.libraryManagementSystem.entity.User;
import com.excel.libraryManagementSystem.repository.BookHistoryRepository;
import com.excel.libraryManagementSystem.repository.BookRepository;
import com.excel.libraryManagementSystem.repository.UserRepository;
import com.excel.libraryManagementSystem.service.LibraryService;
import com.excel.libraryManagementSystem.util.LibraryUtils;

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

    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream().map(LibraryUtils::userEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto getUserByUserId(String userId) {
        Optional<User> userOptional = userRepository.findByUserId(userId);
        return userOptional.map(LibraryUtils::userEntityToDto).orElse(null);
    }

	@Override
	public List<BookDto> getAllBooks() {
		return bookRepository.findAll().stream().map(LibraryUtils::bookEntityToDto)
				.collect(Collectors.toList());
	}

	@Override
	public BookDto getBookByBookId(String bookId) {
		Optional<Book> bookOptional = bookRepository.findByBookId(bookId);
		return bookOptional.map(LibraryUtils::bookEntityToDto).orElse(null);
	}

}
