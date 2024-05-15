package com.excel.springorm;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.excel.springorm.dao.StudentDao;
import com.excel.springorm.entities.Student;

public class App {
    public static void main( String[] args ) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("com/excel/springorm/config.xml");

        StudentDao dao = context.getBean("studentDao", StudentDao.class);

        Student newStudent = new Student();
        newStudent.setName("Sachin");
        newStudent.setAddress("Mysore");
        
//        for insert
//        int insertedId = dao.insert(newStudent);
//        System.out.println("Student inserted with ID: " + insertedId);

//        for getting all data
//        System.out.println("All Students:");
//        for (Student student : dao.getAllStudents()) {
//            System.out.println(student);
//        }
//
//        for getting single data
//        int studentId = 2; 
//        Student retrievedStudent = dao.getStudentById(studentId);
//        System.out.println("Retrieved student with ID " + studentId + ": " + retrievedStudent);
        
//        for updating data
//        retrievedStudent.setName("Manikanta");
//        retrievedStudent.setAddress("Chennai");
//        dao.update(retrievedStudent);
//        System.out.println("Student updated: " + retrievedStudent);
//
//        for deleting data
//        dao.delete(retrievedStudent);
//        System.out.println("Student deleted: " + retrievedStudent);
//
//        context.close();
    }
}
