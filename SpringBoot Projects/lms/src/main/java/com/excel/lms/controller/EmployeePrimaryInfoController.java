package com.excel.lms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.excel.lms.dto.EmployeePrimaryInfoDto;
import com.excel.lms.response.CommonResponse;
import com.excel.lms.service.EmployeePrimaryInfoService;

import static com.excel.lms.constant.EmployeePrimaryInfoConstant.EMPLOYEE_ADDED_MESSAGE;

import java.util.List;


@RestController
@RequestMapping(path = "/api/pinfo", method = {RequestMethod.POST, RequestMethod.PUT})
public class EmployeePrimaryInfoController {
	
	@Autowired
	private EmployeePrimaryInfoService employeePrimaryInfoService;
	
	@GetMapping(path = "/get")
	public List<EmployeePrimaryInfoDto> getAllEmployees() {
		return null;
	}
	
	@PostMapping(path = "/add")
	public ResponseEntity<CommonResponse<EmployeePrimaryInfoDto>> addEmployeePrimaryInfo(@RequestBody EmployeePrimaryInfoDto employeePrimaryInfoDto){
		EmployeePrimaryInfoDto newdto = employeePrimaryInfoService.addEmployeePrimaryInfo(employeePrimaryInfoDto);
				return ResponseEntity.status(HttpStatus.CREATED)
						.body(CommonResponse.<EmployeePrimaryInfoDto>builder().data(newdto)
								.isError(false).message(EMPLOYEE_ADDED_MESSAGE).build());
	}
}
