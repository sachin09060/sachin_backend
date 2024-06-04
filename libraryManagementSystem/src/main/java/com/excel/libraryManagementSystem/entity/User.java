package com.excel.libraryManagementSystem.entity;

import java.time.LocalDateTime;
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
	
	private String name;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	private Long phone;
	
	@Column(unique = true)
	private String email;
	
	private String address;
	
	private String password;
	
	@Column(name = "confirm_password")
	private String confirmPassword;
	
    @Column(name = "created_at")
	private LocalDateTime createdAt;
    
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "user")
    private List<Contact> contacts;
    
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "user")
    private List<BookHistory> bookHistories;
    
}