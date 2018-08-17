package com.samriddh.spring.jdbc.main;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.samriddh.spring.jdbc.dao.EmployeeDAO;
import com.samriddh.spring.jdbc.model.Employee;

public class SpringMain {
	
	public static void main(String[] args) {
		//Get the Spring Context
		System.out.println("DONE");
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		
		//Get the EmployeeDAO Bean
		EmployeeDAO employeeDAO = ctx.getBean("employeeDAO", EmployeeDAO.class);
		
		//Run some tests for JDBC CRUD operations
		Employee emp = new Employee();
		String id="002";
		emp.setId(id);
		emp.setFname("Pankaj");
		emp.setLname("Ranka");
		emp.setEmail("PankajR@yahoo.com");
		
		//Create
		employeeDAO.save(emp);
		
		//Read
		Employee emp1 = employeeDAO.getById(id);
		System.out.println("Employee Retrieved::"+emp1);
		
		//Update
		emp.setEmail("PankajRanka@gmail.com");
		employeeDAO.update(emp);
		
		//Get All
		List<Employee> empList = employeeDAO.getAll();
		System.out.println(empList);
		
		//Delete
		employeeDAO.deleteById(id);
		
		//Close Spring Context
		ctx.close();
		
		
	}
}
