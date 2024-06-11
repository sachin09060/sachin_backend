package com.excel.libraryManagementSystem.service.impl;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.excel.libraryManagementSystem.constant.BookConstants;
import com.excel.libraryManagementSystem.constant.BookHistoryConstants;
import com.excel.libraryManagementSystem.constant.ContactUsConstant;
import com.excel.libraryManagementSystem.constant.UserConstants;
import com.excel.libraryManagementSystem.dto.AdminDto;
import com.excel.libraryManagementSystem.dto.BookDto;
import com.excel.libraryManagementSystem.dto.BookHistoryDto;
import com.excel.libraryManagementSystem.dto.ContactDto;
import com.excel.libraryManagementSystem.dto.UserDto;
import com.excel.libraryManagementSystem.entity.Admin;
import com.excel.libraryManagementSystem.entity.Book;
import com.excel.libraryManagementSystem.entity.BookHistory;
import com.excel.libraryManagementSystem.entity.Contact;
import com.excel.libraryManagementSystem.entity.User;
import com.excel.libraryManagementSystem.enums.Genre;
import com.excel.libraryManagementSystem.exception.BookNotFoundException;
import com.excel.libraryManagementSystem.exception.PasswordMismatchException;
import com.excel.libraryManagementSystem.exception.UserAlreadyPresentException;
import com.excel.libraryManagementSystem.exception.UserNotFoundException;
import com.excel.libraryManagementSystem.repository.AdminRepository;
import com.excel.libraryManagementSystem.repository.BookHistoryRepository;
import com.excel.libraryManagementSystem.repository.BookRepository;
import com.excel.libraryManagementSystem.repository.ContactRepository;
import com.excel.libraryManagementSystem.repository.UserRepository;
import com.excel.libraryManagementSystem.service.LibraryService;
import com.excel.libraryManagementSystem.util.LibraryUtils;
import org.springframework.mail.SimpleMailMessage;


@Service
public class LibraryServiceImpl implements LibraryService {
	
//	Initializing Repositories___________________________________________________________________________________________________
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private BookHistoryRepository bookHistoryRepository;
	
	@Autowired
	private ContactRepository contactRepository;
	
	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
    private JavaMailSender emailSender;

//	Add User Information________________________________________________________________________________________________________
	
	@Override
	public String addUserInfo(UserDto userDto) {
		Optional<User> userOptional = userRepository.findByEmail(userDto.getEmail());
		if(userOptional.isPresent()) {
			throw new UserAlreadyPresentException(UserConstants.USER_ID_ALREADY_PRESENT);
		}
		User userEntity = LibraryUtils.userDtoToEntity(userDto);
		if(!userDto.getPassword().equals(userDto.getConfirmPassword())) {
			throw new PasswordMismatchException(UserConstants.PASSWORD_MISMATCH);
		}
		return userRepository.save(userEntity).getEmail();
	}
	
//	Add Book Information________________________________________________________________________________________________________

	@Override
	public String addBookInfo(BookDto bookDto) {
		Book bookEntity = LibraryUtils.bookDtoToEntity(bookDto);
	    if (bookEntity.getAvailableCopies() > bookEntity.getTotalCopies()) {
	        throw new IllegalArgumentException("Available copies cannot exceed total copies.");
	    }
		return bookRepository.save(bookEntity).getBookId();
	}
	
	
//	Add transactions___________________________________________________________________________________________________________

	@Override
	public String addTransactionsInfo(BookHistoryDto bookHistoryDto) {
		Optional<BookHistory> optional = bookHistoryRepository.findByBookBookIdAndUserEmail(bookHistoryDto.getBookId(), bookHistoryDto.getEmail());
		if(!optional.isPresent()) {
			Optional<User> userOptional = userRepository.findByEmail(bookHistoryDto.getEmail());
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
				
				return userRepository.save(userEntity).getEmail();
			}

		}
		throw new BookNotFoundException(BookHistoryConstants.BOOK_ALREADY_TAKEN);
	}
	
//	Add Contact us message__________________________________________________________________________________________________________
    @Override
	public String addContactUs(ContactDto contactDto) {
		Contact contactEntity = LibraryUtils.contactDtoToEntity(contactDto);
		return contactRepository.save(contactEntity).getMessage();
	}
    
//  Add Admin_____________________________________________________________________________________________________________________
	@Override
	public String addAdmin(AdminDto adminDto) {
		Admin adminEntity = LibraryUtils.adminEntityToDto(adminDto);
		return adminRepository.save(adminEntity).getAdminId();
	}
    
    
//	Get Users_______________________________________________________________________________________________________________________
	@Override	
	public List<UserDto> getAllUsers(String name, String email, String address) {
	    List<UserDto> collect = userRepository.findAll().stream()
	            .map(LibraryUtils::userEntityToDto)
	            .sorted(Comparator.comparing(UserDto::getCreatedAt).reversed())
	            .collect(Collectors.toList());

	    if (email != null) {
	    	return collect.stream()
	    			.filter(u -> u.getEmail().toLowerCase().contains(email))
	    			.collect(Collectors.toList());
	    } 
	    else if (name != null) {
	        return collect.stream()
	                .filter(u -> u.getName().toLowerCase().contains(name))
	                .collect(Collectors.toList());
	    } 
	    else if (address != null) {
	    	return collect.stream()
	    			.filter(u -> u.getAddress().toLowerCase().contains(address))
	    			.collect(Collectors.toList());
	    }
	    return collect;
	}
    
//  __________________________________________________________________________________________________________________

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
                    .filter(b -> b.getBookName().toLowerCase().contains(bookName.toLowerCase()))
                    .collect(Collectors.toList());
        } else if (author != null) {
            return collect.stream()
                    .filter(b -> b.getAuthor().toLowerCase().contains(author.toLowerCase()))
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
	public List<BookHistoryDto> getAllHistory(String email, String bookId) {
	    List<BookHistoryDto> allHistory = bookHistoryRepository.findAll().stream()
	            .map(LibraryUtils::bookHistoryEntityToDto)
	            .collect(Collectors.toList());

	    if (email != null) {
	        return allHistory.stream()
	                .filter(history -> history.getEmail().equals(email))
	                .collect(Collectors.toList());
	    } else if (bookId != null) {
	        return allHistory.stream()
	                .filter(history -> history.getBookId().equals(bookId))
	                .collect(Collectors.toList());
	    } else {
	        return allHistory;
	    }
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
		Optional<User> userOptional = userRepository.findByEmail(userDto.getEmail());
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
	    Optional<Contact> optional = contactRepository.findById(contactDto.getId());
	    if (optional.isPresent()) {
	        contactRepository.delete(optional.get());
	    } else {
	        throw new BookNotFoundException(ContactUsConstant.REQUEST_EMAIL_NOT_FOUNDS);
	    }
	}


//	Update User_________________________________________________________________________________________________________________
	@Override
	public String updateUser(UserDto userDto) {
		Optional<User> userOptional = userRepository.findByEmail(userDto.getEmail());
		if(userOptional.isPresent()) {
			User user = userOptional.get();
			user.setName(userDto.getName());
			user.setGender(userDto.getGender());
			user.setPhone(userDto.getPhone());
			user.setAddress(userDto.getAddress());
			user.setPassword(userDto.getPassword());
			user.setConfirmPassword(userDto.getConfirmPassword());
			user.setCreatedAt(userDto.getCreatedAt());
			
			userRepository.save(user);
			
			return userDto.getEmail();
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
			
			bookRepository.save(book);
			
			return bookDto.getBookId();
		}else {
			throw new BookNotFoundException(BookConstants.BOOK_ID_NOT_FOUND);
		}
		
	}
	
// Update Available Books______________________________________________________________________________________________________
	
	@Override
	public String updateAvailableBook(BookDto bookDto) {
		Optional<Book> optional = bookRepository.findByBookId(bookDto.getBookId());
		if(optional.isPresent()) {
			Book book = optional.get();
			Integer count = book.getAvailableCopies();
			if (count>0) {
				Integer available = count - 1;
				book.setAvailableCopies(available);
				Book save = bookRepository.save(book);
				return save.getBookId();
			}
			
			throw new BookNotFoundException("Book is not available!");
		}
		return null;
	}
	
// Incrementing Available Books______________________________________________________________________________________________________

	@Override
	public String incrementAvailableBook(BookDto bookDto) {
		Optional<Book> optional = bookRepository.findByBookId(bookDto.getBookId());
		if(optional.isPresent()) {
			Book book = optional.get();
			Integer count = book.getAvailableCopies();
			Integer available = count + 1;
			
			book.setAvailableCopies(available);
			Book save = bookRepository.save(book);
			return save.getBookId();
		}
		return null;
	}
	
//	Update Book History________________________________________________________________________________________________________

	@Override
	public Integer updateBookHistory(BookHistoryDto bookHistoryDto) {
		Optional<BookHistory> optional = bookHistoryRepository.findByBookBookIdAndUserEmail(bookHistoryDto.getBookId(), bookHistoryDto.getEmail());
		
		if(optional.isPresent()) {
			BookHistory history = optional.get();
			history.setDueDate(bookHistoryDto.getDueDate());
			history.setIssuedDate(bookHistoryDto.getIssuedDate());
			history.setReturnDate(bookHistoryDto.getReturnDate());
			history.setRenewed(bookHistoryDto.getRenewed());
			history.setReturned(bookHistoryDto.getReturned());
			
			bookHistoryRepository.save(history);
			
			return bookHistoryDto.getHistoryId();
		}else {
			throw new BookNotFoundException(BookConstants.BOOK_ID_NOT_FOUND);
		}
	}


//	User Login_________________________________________________________________________________________________________________	
		@Override
		public UserDto userLogin(UserDto dto) {
			Optional<User> optional = userRepository.findByEmail(dto.getEmail());
			if(optional.isPresent()) {
				User user = optional.get();
				if(user.getEmail().equals(dto.getEmail())
						&& user.getPassword().equals(dto.getPassword())) {
					return LibraryUtils.loginUserEntityToDto(user);
				}
				else {
		              throw new UserNotFoundException(UserConstants.PASSWORD_NOT_PRESENT);
				}	
			}
	        throw new UserNotFoundException(UserConstants.EMAIL_ID_NOT_PRESENT);
		}
		
//	Admin Login_________________________________________________________________________________________________________________
		@Override
		public String adminLogin(AdminDto adminDto) {
			Optional<Admin> optional = adminRepository.findByAdminId(adminDto.getAdminId());
			if(optional.isPresent()) {
				Admin admin = optional.get();
				if(admin.getAdminId().equals(adminDto.getAdminId()) && 
						admin.getPassword().equals(adminDto.getPassword())) {
					return admin.getAdminId();
				}
				else {
					throw new UserNotFoundException("AdminId Already Present!");
				}
			}
			throw new UserNotFoundException("AdminId not Present!");
		}
		
//	User forget password________________________________________________________________________________________________________
		
		@Override
		public String forgotPassword(UserDto dto) {
			Optional<User> optional = userRepository.findByEmail(dto.getEmail());
					if(optional.isPresent()) {
						User user = optional.get();
						user.setPassword(dto.getPassword());
						user.setConfirmPassword(dto.getConfirmPassword());
						return userRepository.save(user).getEmail();
					}
		        throw new UserNotFoundException("Invalid Email!");
		}
		
		
//	Mail sending_________________________________________________________________________________________________________________
		
		@Override
	    public void sendSimpleMessage(String to, String subject, String text) {
	        SimpleMailMessage message = new SimpleMailMessage();
	        message.setTo(to);
	        message.setSubject(subject);
	        message.setText(text);
	        emailSender.send(message);
	    }

}
