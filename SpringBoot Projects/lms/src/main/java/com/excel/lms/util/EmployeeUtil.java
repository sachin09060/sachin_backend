package com.excel.lms.util;

import com.excel.lms.dto.EmployeePrimaryInfoDto;
import com.excel.lms.entity.EmployeePrimaryInfo;

public class EmployeeUtil {

	public static EmployeePrimaryInfo employeePrimaryInfoDtoToEntity(EmployeePrimaryInfoDto dto) {
		return EmployeePrimaryInfo.builder()
			.employeeId(dto.getEmployeeId())
			.employeeName(dto.getEmployeeName())
			.dateOfJoining(dto.getDateOfJoining())
			.dateOfBirth(dto.getDateOfBirth())
			.email(dto.getEmail())
			.bloodGroup(dto.getBloodGroup())
			.designation(dto.getDesignation())
			.gender(dto.getGender())
			.nationality(dto.getNationality())
			.employeeStatus(dto.getEmployeeStatus())
			.build();
	}
	
	public static EmployeePrimaryInfoDto employeePrimaryInfoEntitytoDto(EmployeePrimaryInfo employee) {
		return EmployeePrimaryInfoDto.builder()
			.id(employee.getId())
			.employeeId(employee.getEmployeeId())
			.employeeName(employee.getEmployeeName())
			.dateOfJoining(employee.getDateOfJoining())
			.dateOfBirth(employee.getDateOfBirth())
			.email(employee.getEmail())
			.bloodGroup(employee.getBloodGroup())
			.designation(employee.getDesignation())
			.gender(employee.getGender())
			.nationality(employee.getNationality())
			.employeeStatus(employee.getEmployeeStatus())
			.build();
	}
}
