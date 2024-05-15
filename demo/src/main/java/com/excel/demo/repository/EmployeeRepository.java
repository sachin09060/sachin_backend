package com.excel.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.excel.demo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
