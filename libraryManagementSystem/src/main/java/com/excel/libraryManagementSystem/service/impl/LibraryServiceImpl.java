package com.excel.libraryManagementSystem.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excel.libraryManagementSystem.constant.BookConstants;
import com.excel.libraryManagementSystem.constant.ContactUsConstant;
import com.excel.libraryManagementSystem.constant.UserConstants;
import com.excel.libraryManagementSystem.dto.BookDto;
import com.excel.libraryManagementSystem.dto.BookHistoryDto;
import com.excel.libraryManagementSystem.dto.ContactDto;
import com.excel.libraryManagementSystem.dto.UserDto;
import com.excel.libraryManagementSystem.entity.Book;
import com.excel.libraryManagementSystem.entity.BookHistory;
import com.excel.libraryManagementSystem.entity.Contact;
import com.excel.libraryManagementSystem.entity.User;
import com.excel.libraryManagementSystem.enums.Genre;
import com.excel.libraryManagementSystem.exception.BookNotFoundException;
import com.excel.libraryManagementSystem.exception.UserAlreadyPresentException;
import com.excel.libraryManagementSystem.exception.UserNotFoundException;
import com.excel.libraryManagementSystem.repository.BookHistoryRepository;
import com.excel.libraryManagementSystem.repository.BookRepository;
import com.excel.libraryManagementSystem.repository.ContactRepository;
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
	
	@Autowired
	private ContactRepository contactRepository;

//	Add User Information________________________________________________________________________________________________________
	@Override
	public String addUserInfo(UserDto userDto) {
		Optional<User> userOptional = userRepository.findByUserId(userDto.getUserId());
		if(userOptional.isPresent()) {
			throw new UserAlreadyPresentException(UserConstants.USER_ID_ALREADY_PRESENT);
		}
		User userEntity = LibraryUtils.userDtoToEntity(userDto);
		return userRepository.save(userEntity).getUserId();
	}
	
//	Add Book Information________________________________________________________________________________________________________

	@Override
	public String addBookInfo(BookDto bookDto) {
		Book bookEntity = LibraryUtils.bookDtoToEntity(bookDto);
		return bookRepository.save(bookEntity).getBookId();
	}
	
//	Add transactions___________________________________________________________________________________________________________

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
	
	
//	Add Contact us message__________________________________________________________________________________________________________
@Override
	public String addContactUs(ContactDto contactDto) {
		Contact contactEntity = LibraryUtils.contactDtoToEntity(contactDto);
		return contactRepository.save(contactEntity).getMessage();
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
        List<BookDto> collect = bookRepository.findAll().stream()
                .map(LibraryUtils::bookEntityToDto)
                .sorted(Comparator.comparing(BookDto::getAddedDate).reversed())
                .collect(Collectors.toList());

        if (bookId != null) {
            return collect.stream()
                    .filter(b -> b.getBookId().equalsIgnoreCase(bookId))
                    .collect(Collectors.toList());
        } else if (bookName != null) {
            return collect.stream()
                    .filter(b -> b.getBookName().toLowerCase().startsWith(bookName.toLowerCase()))
                    .collect(Collectors.toList());
        } else if (author != null) {
            return collect.stream()
                    .filter(b -> b.getAuthor().toLowerCase().startsWith(author.toLowerCase()))
                    .collect(Collectors.toList());
        } else if (genre != null) {
            return collect.stream()
                    .filter(b -> b.getGenre().equals(genre))
                    .collect(Collectors.toList());
        }

        return collect;
    }

	
//  _________________________________________________________________________________________________________________________

	
//	Get Book History_________________________________________________________________________________________________________

	@Override
	public List<BookHistoryDto> getAllHistory(String userId, String bookId) {
		List<BookHistoryDto> collect = bookHistoryRepository.findAll().stream().map(LibraryUtils::bookHistoryEntityToDto)
		.collect(Collectors.toList());
		if(userId == null && bookId ==null) {
			return collect;
		}
		return collect;
	}
	
//	Get Message Requests_____________________________________________________________________________________________________

	@Override
	public List<ContactDto> getAllRequests(String name, String email) {
		List<ContactDto> collect = contactRepository.findAll().stream().map(LibraryUtils::contactEntityToDto)
		.collect(Collectors.toList());
	    
		if (name != null) {
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


// Delete user ______________________________________________________________________________________________________________

	@Override
	public void deleteUser(UserDto userDto) {
		Optional<User> userOptional = userRepository.findByUserId(userDto.getUserId());
		if(userOptional.isPresent()) {
			userRepository.delete(userOptional.get());
		}else {
			throw new UserNotFoundException(UserConstants.USER_ID_NOT_FOUND);
		}
	}
	
//	Delete Book________________________________________________________________________________________________________________

	@Override
	public void deleteBook(BookDto bookDto) {
		Optional<Book> bookOptional = bookRepository.findByBookId(bookDto.getBookId());
		if(bookOptional.isPresent()) {
			bookRepository.delete(bookOptional.get());
		}else {
			throw new BookNotFoundException(BookConstants.BOOK_ID_NOT_FOUND);
		}
	}
	
//	Delete message request___________________________________________________________________________________________________

	@Override
	public void deleteMessageRequest(ContactDto contactDto) {
	    Optional<Contact> optionalEmail = contactRepository.findByEmail(contactDto.getEmail());
	    if (optionalEmail.isPresent()) {
	        contactRepository.delete(optionalEmail.get());
	    } else {
	        throw new BookNotFoundException(ContactUsConstant.REQUEST_EMAIL_NOT_FOUNDS);
	    }
	}


//	Update User_________________________________________________________________________________________________________________
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
	
//	Update Book__________________________________________________________________________________________________________________

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
		}else {
			throw new BookNotFoundException(BookConstants.BOOK_ID_NOT_FOUND);
		}
		
	}

}
