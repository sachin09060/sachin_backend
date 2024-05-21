package com.excel.libraryManagementSystem.entity;

import java.time.LocalDate;
import java.util.List;

import com.excel.libraryManagementSystem.enums.Gender;

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
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "user_id")
	private String userId;
	
	private String name;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	private Long phone;
	
	private String email;
	
	private String address;
	
	@Column(name = "is_librarian")
	private Boolean isLibrarian;
	
	@Column(name = "is_user")
	private Boolean isUser;
	
    @Column(name = "created_at")
	private LocalDate createdAt;
    
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "user")
    private List<BookHistory> bookHistories;
    
}
