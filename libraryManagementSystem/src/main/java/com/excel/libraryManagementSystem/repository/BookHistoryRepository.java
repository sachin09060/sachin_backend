package com.excel.libraryManagementSystem.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.excel.libraryManagementSystem.entity.BookHistory;

public interface BookHistoryRepository extends JpaRepository<BookHistory, Integer>{

	Optional<BookHistory> findByHistoryId(Integer historyId);
	
	Optional<BookHistory> findByBookBookIdAndUserEmail(String bookId,String email);

}
