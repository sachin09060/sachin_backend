package com.excel.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext context = new ClassPathXmlApplicationContext("com/excel/spring/config.xml");
    	
    	Student student1 = (Student)context.getBean("student");
    	Student student2 = (Student)context.getBean("student1");
    	Student student3 = (Student)context.getBean("student2");
    	
    	System.out.println(student1);
    	System.out.println(student2);
    	System.out.println(student3);
    }
}
