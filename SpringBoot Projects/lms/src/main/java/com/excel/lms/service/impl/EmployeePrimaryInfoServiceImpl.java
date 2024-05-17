package com.excel.lms.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excel.lms.dto.EmployeePrimaryInfoDto;
import com.excel.lms.entity.EmployeePrimaryInfo;
import com.excel.lms.repository.EmployeePrimaryInfoRepository;
import com.excel.lms.service.EmployeePrimaryInfoService;
import com.excel.lms.util.EmployeeUtil;

@Service
public class EmployeePrimaryInfoServiceImpl implements EmployeePrimaryInfoService{
	
	@Autowired
	private EmployeePrimaryInfoRepository employeePrimaryInfoRepository;

	@Override
	public EmployeePrimaryInfoDto addEmployeePrimaryInfo(EmployeePrimaryInfoDto dto) {
		EmployeePrimaryInfo employeePrimaryInfo = EmployeeUtil.employeePrimaryInfoDtoToEntity(dto);
		EmployeePrimaryInfo employee = employeePrimaryInfoRepository.save(employeePrimaryInfo);
		return EmployeeUtil.employeePrimaryInfoEntitytoDto(employee);
	}
	
	private List<EmployeePrimaryInfoDto> getAllEmployees() {
		return employeePrimaryInfoRepository.findAll().stream()
				.map(e -> ).toList();
	}
	

}
