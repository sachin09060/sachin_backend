package com.excel.lms.entity;


import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
		@Column(name = "employee_secondary_id")
		private Integer employeeSecondaryId;
		private String pan;
		private String aadhar;
		private String fatherName;
		private String motherName;
		private String spouse;
		
		@Column(name = "passport_no")
		private String passportNo;
		private String mariatlStatus;
		
		@JoinColumn(name = "employee_id")
		@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
		private EmployeePrimaryInfo employee;
}
