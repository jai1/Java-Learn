package com.javacodegeeks.snippets.enterprise;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.javacodegeeks.snippets.enterprise.JDBCEmployeeDAO;

public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"SpringConfig.xml");
		JDBCEmployeeDAO jdbcEmployeeDAO = (JDBCEmployeeDAO) context
				.getBean("jdbcEmployeeDAO");
		Employee employee3 = new Employee(454, "jai", 34);
		jdbcEmployeeDAO.insert(employee3);
		Employee employee4 = jdbcEmployeeDAO.findById(456);
		System.out.println(employee4);
		((ConfigurableApplicationContext) context).close();
		List<Employee> employees = jdbcEmployeeDAO.findAll();
        System.out.println(employees);
	}
}
