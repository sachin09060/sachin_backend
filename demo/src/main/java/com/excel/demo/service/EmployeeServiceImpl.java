package com.excel.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excel.demo.constant.EmployeeConstant;
import com.excel.demo.dto.EmployeeDto;
import com.excel.demo.entity.Employee;
import com.excel.demo.exception.EmployeeNotFoundException;
import com.excel.demo.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public EmployeeDto addEmployee(EmployeeDto dto) {
		Employee employee = Employee.builder()
				.firstName(dto.getFirstName())
				.lastName(dto.getLastName())
				.mobileNo(dto.getMobileNo())
				.aadharNo(dto.getAadharNo())
				.panNo(dto.getPanNo())
				.employeeNo(dto.getEmployeeNo())
				.build();
		
		Employee save = employeeRepository.save(employee);
		
		return EmployeeDto.builder().id(save.getId())
				.firstName(save.getFirstName())
				.lastName(save.getLastName())
				.mobileNo(save.getMobileNo())
				.aadharNo(save.getAadharNo())
				.panNo(save.getPanNo())
				.employeeNo(save.getEmployeeNo()).build();
	}

	@Override
	public List<EmployeeDto> getEmployeebyId(EmployeeDto dto) {
		return employeeRepository.findById(dto.getId()).stream()
				.map(e -> EmployeeDto.builder()
						.id(e.getId())
						.aadharNo(e.getAadharNo())
						.firstName(e.getFirstName())
						.lastName(e.getLastName())
						.mobileNo(e.getMobileNo())
						.panNo(e.getPanNo())
						.employeeNo(e.getEmployeeNo()).build())
				.toList();
	}
	
	@Override
	public List<EmployeeDto> getAllEmployees() {
		return employeeRepository.findAll().stream()
				.map(e -> EmployeeDto.builder()
						.id(e.getId())
						.aadharNo(e.getAadharNo())
						.firstName(e.getFirstName())
						.lastName(e.getLastName())
						.mobileNo(e.getMobileNo())
						.panNo(e.getPanNo())
						.employeeNo(e.getEmployeeNo()).build())
				.toList();
	}

	
	@Override
	public void deleteEmployee(EmployeeDto dto) {
		Optional<Employee> optional = employeeRepository.findById(dto.getId());
		if(optional.isPresent())
			employeeRepository.delete(optional.get());
		else
			throw new EmployeeNotFoundException(EmployeeConstant.EMPLOYEE_ID_NOT_FOUND);
	}

	@Override
	public EmployeeDto updateFirstName(EmployeeDto dto) {
		Optional<Employee> optional = employeeRepository.findById(dto.getId());
		if(!optional.isPresent()) {
			return null;
		}
		
		Employee employee = optional.get();
		employee.setFirstName(dto.getFirstName());
        Employee emp = employeeRepository.save(employee);
        
        return EmployeeDto.builder()
        		.id(emp.getId())
        		.firstName(emp.getFirstName())
        		.lastName(emp.getLastName())
        		.mobileNo(emp.getMobileNo())
        		.aadharNo(emp.getAadharNo())
        		.panNo(emp.getPanNo())
        		.employeeNo(emp.getEmployeeNo())
        		.build();
	}

	@Override
	public EmployeeDto updateLastName(EmployeeDto dto) {
		Optional<Employee> optional = employeeRepository.findById(dto.getId());
		if(!optional.isPresent()) {
			return null;
		}
		
		Employee employee = optional.get();
		employee.setLastName(dto.getLastName());
        Employee emp = employeeRepository.save(employee);
		
        return EmployeeDto.builder()
        		.id(emp.getId())
        		.firstName(emp.getFirstName())
        		.lastName(emp.getLastName())
        		.mobileNo(emp.getMobileNo())
        		.aadharNo(emp.getAadharNo())
        		.panNo(emp.getPanNo())
        		.employeeNo(emp.getEmployeeNo())
        		.build();
	}

	@Override
	public EmployeeDto updatePhoneNo(EmployeeDto dto) {
		Optional<Employee> optional = employeeRepository.findById(dto.getId());
		if(!optional.isPresent()) {
			return null;
		}
		
		Employee employee = optional.get();
		employee.setMobileNo(dto.getMobileNo());
        Employee emp = employeeRepository.save(employee);
		
        return EmployeeDto.builder()
        		.id(emp.getId())
        		.firstName(emp.getFirstName())
        		.lastName(emp.getLastName())
        		.mobileNo(emp.getMobileNo())
        		.aadharNo(emp.getAadharNo())
        		.panNo(emp.getPanNo())
        		.employeeNo(emp.getEmployeeNo())
        		.build();
	}

	@Override
	public EmployeeDto updateAadharNo(EmployeeDto dto) {
		Optional<Employee> optional = employeeRepository.findById(dto.getId());
		if(!optional.isPresent()) {
			return null;
		}
		
		Employee employee = optional.get();
		employee.setAadharNo(dto.getAadharNo());
        Employee emp = employeeRepository.save(employee);
		
        return EmployeeDto.builder()
        		.id(emp.getId())
        		.firstName(emp.getFirstName())
        		.lastName(emp.getLastName())
        		.mobileNo(emp.getMobileNo())
        		.aadharNo(emp.getAadharNo())
        		.panNo(emp.getPanNo())
        		.employeeNo(emp.getEmployeeNo())
        		.build();
	}

	@Override
	public EmployeeDto updatePanNo(EmployeeDto dto) {
		Optional<Employee> optional = employeeRepository.findById(dto.getId());
		if(!optional.isPresent()) {
			return null;
		}
		
		Employee employee = optional.get();
		employee.setPanNo(dto.getPanNo());
        Employee emp = employeeRepository.save(employee);
		
        return EmployeeDto.builder()
        		.id(emp.getId())
        		.firstName(emp.getFirstName())
        		.lastName(emp.getLastName())
        		.mobileNo(emp.getMobileNo())
        		.aadharNo(emp.getAadharNo())
        		.panNo(emp.getPanNo())
        		.employeeNo(emp.getEmployeeNo())
        		.build();
	}

	@Override
	public EmployeeDto updateEmployeeNo(EmployeeDto dto) {
		Optional<Employee> optional = employeeRepository.findById(dto.getId());
		if(!optional.isPresent()) {
			return null;
		}
		
		Employee employee = optional.get();
		employee.setEmployeeNo(dto.getEmployeeNo());
        Employee emp = employeeRepository.save(employee);
		
        return EmployeeDto.builder()
        		.id(emp.getId())
        		.firstName(emp.getFirstName())
        		.lastName(emp.getLastName())
        		.mobileNo(emp.getMobileNo())
        		.aadharNo(emp.getAadharNo())
        		.panNo(emp.getPanNo())
        		.employeeNo(emp.getEmployeeNo())
        		.build();
	}

}
