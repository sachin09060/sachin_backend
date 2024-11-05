package com.excel.springjdbc.dao;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.excel.springjdbc.entities.Student;

@Component("studentDao")
public class StudentDaoImpl implements StudentDao{
	

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int insertStudent(Student student) {
		String query = "insert into student(id, name, address) values(?,?,?)";
		int res = jdbcTemplate.update(query, student.getId(), student.getName(),student.getAddress());
		return res;
	}
	
	@Override
	public Student getStudentById(int id) {
		String query = "select * from student where id = ?";
		return jdbcTemplate.queryForObject(query, new Object[] { id }, new StudentMapper());
	}
	
	@Override
	public List<Student> getStudent() {
		String query = "select * from student";
		return jdbcTemplate.query(query, new StudentMapper());
	}
	
	@Override
	public int updateStudent(Student student) {
		String query = "update student set name = ?, address = ? where id = ?\"";
		int res = jdbcTemplate.update(query, student.getId(), student.getName(),student.getAddress());
		return res;
	}
	
	
	@Override
	public boolean deleteStudent(Student student) {
		String query = "delete from student where id = ?";
		boolean res = jdbcTemplate.update(query, student.getId()) > 0;
		return res;
	}
	
}
