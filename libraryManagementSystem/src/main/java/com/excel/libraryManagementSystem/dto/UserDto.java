package com.excel.libraryManagementSystem.dto;

import java.time.LocalDateTime;

import com.excel.libraryManagementSystem.enums.Gender;

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
public class UserDto {
	
	private String userId;
	private String name;
	private Gender gender;
	private Long phone;
	private String email;
	private String address;
	private Boolean isLibrarian;
	private Boolean isUser;
	private LocalDateTime createdAt;
}
