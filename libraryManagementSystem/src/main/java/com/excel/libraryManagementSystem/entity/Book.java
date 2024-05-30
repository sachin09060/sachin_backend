package com.excel.libraryManagementSystem.entity;

import java.time.LocalDateTime;
import java.util.List;

import com.excel.libraryManagementSystem.enums.Genre;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
@Entity
@Table(name = "book")
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "book_id", unique = true)
	private String bookId;
	
	@Column(name = "book_image_url")
	private String bookImgUrl;
	
	@Column(name = "book_name")
	private String bookName;
	
	private String author;
	
	@Enumerated(EnumType.STRING)
	private Genre genre;
	
	private String description;
	
	@Column(name = "added_date")
	private LocalDateTime addedDate;
	
	@Column(name = "total_copies")
	private int totalCopies;
	
	@Column(name = "available_copies")
	private int availableCopies;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "book")
	private List<BookHistory> bookHistories;
}
