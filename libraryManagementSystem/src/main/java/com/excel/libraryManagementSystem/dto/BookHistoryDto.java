package com.excel.libraryManagementSystem.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookHistoryDto {
	private Integer historyId;
	private String email;
	private String bookId;
	private LocalDate issuedDate; 
	private LocalDate dueDate;
	private LocalDate returnDate;
    private Boolean returned;
    private Boolean renewed;
}
