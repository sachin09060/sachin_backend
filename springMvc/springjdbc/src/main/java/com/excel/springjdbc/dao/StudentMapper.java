package com.excel.springjdbc.dao;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.excel.springjdbc.entities.Student;

public class StudentMapper implements RowMapper<Student> {

	public Student mapRow(ResultSet resultSet, int i) throws SQLException {

		Student student = new Student();
		student.setId(resultSet.getInt("id"));
		student.setName(resultSet.getString("name"));
		student.setAddress(resultSet.getString("address"));
		return student;
	}
}