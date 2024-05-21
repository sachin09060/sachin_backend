package com.excel.libraryManagementSystem.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.excel.libraryManagementSystem.entity.BookHistory;

public interface BookHistoryRepository extends JpaRepository<BookHistory, Integer>{
	
}
