package com.excel.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.excel.demo.constant.EmployeeConstant;
import com.excel.demo.dto.EmployeeDto;
import com.excel.demo.service.EmployeeService;

@RestController
public class BaseController {
	
//	@GetMapping("/home")
//	public ResponseEntity<String> homeGetReq() {
//		return ResponseEntity.status(HttpStatus.OK).body("Good Morning!");
//	}
	
//	@PostMapping("/home")
//	public ResponseEntity<String> homePostReq() {
//		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Hello World!");
//	}
	
//	@PostMapping("/home/{s}")
//	public ResponseEntity<String> homePostReq(@PathVariable String s) {
//		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(s);
//	}
	
//	@PostMapping("/home/{str}")
//	public ResponseEntity<String> homePostReq(@PathVariable String str, @RequestParam String s) {
//		return ResponseEntity.status(HttpStatus.ACCEPTED).body(str + " " + s);
//	}
	
//	@PutMapping("/home/{id}")
//	public ResponseEntity<String> homePutReq(@PathVariable String id,@RequestParam String u) {
//		return ResponseEntity.status(HttpStatus.ACCEPTED).body(id+" "+u);
//	}
//	
//	@DeleteMapping("/home/{id}")
//	public ResponseEntity<String> homeDelReq(@PathVariable String id,@RequestParam String d) {
//		return ResponseEntity.status(HttpStatus.ACCEPTED).body(id+" "+d);
//	}
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/getById")
	public ResponseEntity<List<EmployeeDto>> fetchEntity(@RequestBody EmployeeDto employee) {
		return ResponseEntity.ok(employeeService.getEmployeebyId(employee));
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<EmployeeDto>> fetchAllEmployee() {
		return ResponseEntity.ok(employeeService.getAllEmployees());
	}
	
	@PostMapping("/add")
	public ResponseEntity<EmployeeDto> addEmployee(@RequestBody EmployeeDto employee) {
		EmployeeDto dto = employeeService.addEmployee(employee);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteEmployee(@RequestBody EmployeeDto employee) {
		employeeService.deleteEmployee(employee);
		return ResponseEntity.ok(EmployeeConstant.EMPLOYEE_DELETED_SUCCESS);
	}
	
	@PutMapping("/update/firstName")
	public ResponseEntity<String> updateEmployeeFirstName(@RequestBody EmployeeDto dto) {
		employeeService.updateFirstName(dto);
		return ResponseEntity.status(HttpStatus.OK).body(dto.getFirstName());
	}
	
	@PutMapping("/update/lastName")
	public ResponseEntity<String> updateEmployeeLastName(@RequestBody EmployeeDto dto) {
		employeeService.updateLastName(dto);
		return ResponseEntity.status(HttpStatus.OK).body(dto.getLastName());
	}
	
	@PutMapping("/update/phone")
	public ResponseEntity<String> updatePhoneNo(@RequestBody EmployeeDto dto) {
		employeeService.updatePhoneNo(dto);
		return ResponseEntity.status(HttpStatus.OK).body(dto.getMobileNo());
	}
	
	@PutMapping("/update/aadhar")
	public ResponseEntity<String> updateAadharNo(@RequestBody EmployeeDto dto) {
		employeeService.updateAadharNo(dto);
		return ResponseEntity.status(HttpStatus.OK).body(dto.getAadharNo());
	}
	
	@PutMapping("/update/pan")
	public ResponseEntity<String> updatePanNo(@RequestBody EmployeeDto dto) {
		employeeService.updatePanNo(dto);
		return ResponseEntity.status(HttpStatus.OK).body(dto.getPanNo());
	}
	
	@PutMapping("/update/eid")
	public ResponseEntity<String> updateEmployeeNo(@RequestBody EmployeeDto dto) {
		employeeService.updateEmployeeNo(dto);
		return ResponseEntity.status(HttpStatus.OK).body(dto.getEmployeeNo());
	}
}
