package com.excel.springjdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.excel.springjdbc.dao.StudentDao;
import com.excel.springjdbc.entities.Student;

public class App 
{
    public static void main( String[] args )
    {
       ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);
       
       StudentDao dao = context.getBean("studentDao", StudentDao.class);
       
       Student student = new Student();
       student.setId(10);
       student.setName("Sachin");
       student.setAddress("Mysore");
       
       int res = dao.insertStudent(student);
       
       Student getElementById = dao.getStudentById(res);
       
       List<Student> res1 = dao.getStudent();
       
       boolean del = dao.deleteStudent(student);
       
       System.out.println(res + " Record created Successfully");
       System.out.println(res1);
       System.out.println("Deleted Successfully");
       
    }
}
