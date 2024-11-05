package com.excel.libraryManagementSystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.excel.libraryManagementSystem.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{
	
	Optional<Book> findByBookId(String bookId);

}
