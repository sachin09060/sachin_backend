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
import com.excel.demo.response.CommonResponse;
import com.excel.demo.service.EmployeeService;

import static com.excel.demo.constant.EmployeeConstant.EMPLOYEE_ADDED_MESSAGE;
import static com.excel.demo.constant.EmployeeConstant.EMPLOYEE_FIRSTNAME_MESSAGE;
import static com.excel.demo.constant.EmployeeConstant.EMPLOYEE_LASTNAME_MESSAGE;
import static com.excel.demo.constant.EmployeeConstant.ONE_EMPLOYEE_DETAILS;

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
	
//	@GetMapping("/getById")
//	public ResponseEntity<List<EmployeeDto>> fetchEntity(@RequestBody EmployeeDto employee) {
//		return ResponseEntity.ok(employeeService.getEmployeebyId(employee));
//	}
	
	// Base controller
	@GetMapping("/get/{id}")
		public ResponseEntity<CommonResponse<EmployeeDto>> getById(@PathVariable Integer id)
		{ EmployeeDto dto= employeeService.getEmployeebyId(id)
	;
		return ResponseEntity.status(HttpStatus.OK)
				.body(CommonResponse.<EmployeeDto>builder()
						.data(dto).isError(false)
						.message(ONE_EMPLOYEE_DETAILS).build());	
		}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<EmployeeDto>> fetchAllEmployee() {
		return ResponseEntity.ok(employeeService.getAllEmployees());
	}
	
	@PostMapping("/add")
	public ResponseEntity<CommonResponse<EmployeeDto>> addEmployee(@RequestBody EmployeeDto employee) {
		EmployeeDto dto = employeeService.addEmployee(employee);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(CommonResponse.<EmployeeDto>builder().data(dto)
						.isError(false).message(EMPLOYEE_ADDED_MESSAGE).build());
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteEmployee(@RequestBody EmployeeDto employee) {
		employeeService.deleteEmployee(employee);
		return ResponseEntity.ok(EmployeeConstant.EMPLOYEE_DELETED_SUCCESS);
	}
	
	@PutMapping("/update/firstName")
	public ResponseEntity<CommonResponse<EmployeeDto>> updateEmployeeFirstName(@RequestBody EmployeeDto dto) {
		EmployeeDto updateFirstName = employeeService.updateFirstName(dto);
		return ResponseEntity.status(HttpStatus.OK)
				.body(CommonResponse.<EmployeeDto>builder().data(updateFirstName)
						.isError(false).message(EMPLOYEE_FIRSTNAME_MESSAGE).build());
	}
	
	@PutMapping("/update/lastName")
	public ResponseEntity<CommonResponse<EmployeeDto>> updateEmployeeLastName(@RequestBody EmployeeDto dto) {
		EmployeeDto updateLastName = employeeService.updateLastName(dto);
		return ResponseEntity.status(HttpStatus.OK)
				.body(CommonResponse.<EmployeeDto>builder().data(updateLastName)
						.isError(false).message(EMPLOYEE_LASTNAME_MESSAGE).build());
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
