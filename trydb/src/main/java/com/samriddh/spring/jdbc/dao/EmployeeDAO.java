package com.samriddh.spring.jdbc.dao;

import java.util.List;

import com.samriddh.spring.jdbc.model.Employee;

public interface EmployeeDAO {
	public void save(Employee employee);

	public Employee getById(String id);

	public void update(Employee employee);

	public void deleteById(String id);

	public List<Employee> getAll();
}
