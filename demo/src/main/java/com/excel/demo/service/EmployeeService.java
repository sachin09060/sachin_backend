package com.excel.demo.service;

import java.util.List;

import com.excel.demo.dto.EmployeeDto;

public interface EmployeeService {
	public EmployeeDto addEmployee(EmployeeDto dto);
	
	public List<EmployeeDto> getAllEmployees();
	
	public void deleteEmployee(EmployeeDto dto);

	List<EmployeeDto> getEmployeebyId(EmployeeDto dto);

	public EmployeeDto updateFirstName(EmployeeDto dto);

	
}
