package com.excel.lms.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Education {
	UNDERGRADUATE("UNDERGRADUATE"), POSTGRADUATE("POSTGRADUATE");
	
	private final String educationType;
}
