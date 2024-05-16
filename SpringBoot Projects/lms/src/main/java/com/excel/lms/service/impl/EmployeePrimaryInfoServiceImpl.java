package com.excel.lms.service.impl;

import org.springframework.stereotype.Service;

import com.excel.lms.dto.EmployeePrimaryInfoDto;
import com.excel.lms.entity.EmployeePrimaryInfo;
import com.excel.lms.service.EmployeePrimaryInfoService;

@Service
public class EmployeePrimaryInfoServiceImpl implements EmployeePrimaryInfoService{

	@Override
	public EmployeePrimaryInfoDto addEmployeePrimaryInfo(EmployeePrimaryInfoDto dto) {
//		EmployeePrimaryInfoDto employeePrimaryInfo = EmployeePrimaryInfo.builder()
//				.employeeId(dto.getEmployeeId())
//				.emplyeeName(dto.getEmplyeeName())
//				.dateOfJoining(dto.getDateOfJoining())
//				.dateOfBirth(dto.getDateOfBirth())
//				.email(dto.getEmail())
//				.bloodGroup(dto.getBloodGroup())
//				.designation(dto.getDesignation())
//				.gender(dto.getGender())
//				.nationality(dto.getNationality())
//				.employeeStatus(dto.getEmployeeStatus())
//				.build();
//		
//		EmployeePrimaryInfo save = employeePrimaryInfoRepository.save(employeePrimaryInfo);
		return null;
	}

}
