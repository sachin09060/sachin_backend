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
        int insertedId = dao.insert(newStudent);
        System.out.println("Student inserted with ID: " + insertedId);

//        System.out.println("All Students:");
//        for (Student student : dao.getAllStudents()) {
//            System.out.println(student);
//        }
//
//        int studentId = 1; 
//        Student retrievedStudent = dao.getStudentById(studentId);
//        System.out.println("Retrieved student with ID " + studentId + ": " + retrievedStudent);
//
//        retrievedStudent.setAddress("Mangalore");
//        dao.update(retrievedStudent);
//        System.out.println("Student updated: " + retrievedStudent);
//
//        dao.delete(retrievedStudent);
//        System.out.println("Student deleted: " + retrievedStudent);

        context.close();
    }
}
