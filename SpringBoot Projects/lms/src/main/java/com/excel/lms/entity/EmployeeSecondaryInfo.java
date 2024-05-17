package com.excel.lms.entity;


import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "employee_secondary_info")
@RequestMapping("/employeeSecondaryInfo")
public class EmployeeSecondaryInfo {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer empSecondaryId;
		private String pan;
		private String aadhar;
		private String fatherName;
		private String motherName;
		private String spouse;
		private String passportNo;
		private String mariatlStatus;
		
		@OneToOne
		private EmployeePrimaryInfo employee;
}
