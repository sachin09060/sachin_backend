package com.excel.libraryManagementSystem.dto;

import java.time.LocalDate;

import com.excel.libraryManagementSystem.enums.Genre;

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
public class BookDto {
	
	private String bookId;
	private String bookImgUrl;
	private String bookName;
	private String author;
	private Genre genre;
	private String description;
	private LocalDate addedDate;
	private int totalCopies;
	private int availableCopies;
	
}
