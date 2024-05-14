package com.excel.springorm.dao;

import java.util.List;

import com.excel.springorm.entities.Student;

public interface StudentDao {
	int insert(Student student);
	
	List<Student> getAllStudents();
	
	int delete(Student student);
	
	void update(Student student);
}
