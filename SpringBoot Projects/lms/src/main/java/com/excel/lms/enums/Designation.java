package com.excel.lms.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Designation {
	DEVELOPER("DEVELOPER"), TESTER("TESTER");
	
	private final String designationType;
}
