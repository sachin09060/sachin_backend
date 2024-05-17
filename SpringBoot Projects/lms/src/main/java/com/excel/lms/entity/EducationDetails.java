package com.excel.lms.entity;

import java.time.LocalDate;

import org.springframework.web.bind.annotation.RequestMapping;

import com.excel.lms.enums.Education;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
@Table(name = "employee_education_info")
@RequestMapping("/educationDetails")
public class EducationDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer educationId;
	private String educationType;
	private LocalDate yearOfPassing;
	private Double Percentage;
	private String instituteName;
	private String univercityName;
	private String specialization;
	private String state;
	
	@ManyToOne
	private EmployeePrimaryInfo employee;
	
}
