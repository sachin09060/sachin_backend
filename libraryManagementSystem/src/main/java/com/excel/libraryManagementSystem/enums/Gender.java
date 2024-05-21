package com.excel.libraryManagementSystem.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Gender {
	MALE("MALE"),
	FEMALE("FEMALE"),
	OTHER("OTHER");
	
	private final String genderType;
}
