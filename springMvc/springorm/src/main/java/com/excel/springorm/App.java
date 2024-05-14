package com.excel.springorm;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.excel.springorm.dao.StudentDao;

public class App {
    public static void main( String[] args ) {
    	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("com/excel/springorm/config.xml");
    	StudentDao dao = context.getBean("student", StudentDao.class);
    }
}
