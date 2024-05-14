package com.excel.springjdbc.dao;

import java.util.List;

import com.excel.springjdbc.entities.Student;

public interface StudentDao {

	int insertStudent(Student student);
	
	Student getStudentById(int id);
	
	List<Student> getStudent();
	
	int updateStudent(Student student);
	
	boolean  deleteStudent(Student student);

}
