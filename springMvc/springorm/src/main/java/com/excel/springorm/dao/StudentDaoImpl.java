package com.excel.springorm.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.excel.springorm.entities.Student;

public class StudentDaoImpl implements StudentDao{
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public int insert(Student student) {
		Integer i = (Integer) this.hibernateTemplate.save(student);
		return i;
	}

	@Override
	public List<Student> getAllStudents() {
		this.hibernateTemplate.loadAll(Student.class)
		return null;
	}

	@Override
	public int delete(Student student) {
		this.hibernateTemplate.delete(student);
		return 0;
	}

	@Override
	public void update(Student student) {
		this.hibernateTemplate.update(student);
		
	}

}
