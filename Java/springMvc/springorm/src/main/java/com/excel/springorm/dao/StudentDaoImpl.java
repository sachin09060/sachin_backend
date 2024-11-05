package com.excel.springorm.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.excel.springorm.entities.Student;

public class StudentDaoImpl implements StudentDao {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }
    
    @Override
    @Transactional
    public int insert(Student student) {
        Integer i = (Integer) this.hibernateTemplate.save(student);
        return i;
    }

    @Override
    public List<Student> getAllStudents() {
        return this.hibernateTemplate.loadAll(Student.class);
    }

    @Override
    public Student getStudentById(int id) {
        return this.hibernateTemplate.get(Student.class, id);
    }

    @Override
    @Transactional
    public void update(Student student) {
        this.hibernateTemplate.update(student);
    }

    @Override
    @Transactional
    public void delete(Student student) {
        this.hibernateTemplate.delete(student);
    }
}
