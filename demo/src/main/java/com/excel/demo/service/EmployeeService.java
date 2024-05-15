package com.excel.demo.service;

import java.util.List;

import com.excel.demo.dto.EmployeeDto;

public interface EmployeeService {
	public EmployeeDto addEmployee(EmployeeDto dto);
	
	public List<EmployeeDto> getAllEmployees();
	
	public void deleteEmployee(EmployeeDto dto);

	List<EmployeeDto> getEmployeebyId(EmployeeDto dto);

	public EmployeeDto updateFirstName(EmployeeDto dto);

	public EmployeeDto updateLastName(EmployeeDto dto);

	public EmployeeDto updatePhoneNo(EmployeeDto dto);

	public EmployeeDto updateAadharNo(EmployeeDto dto);

	public EmployeeDto updatePanNo(EmployeeDto dto);

	public EmployeeDto updateEmployeeNo(EmployeeDto dto);

	
}
