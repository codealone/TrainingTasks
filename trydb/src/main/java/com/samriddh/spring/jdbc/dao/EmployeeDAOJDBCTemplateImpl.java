package com.samriddh.spring.jdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.samriddh.spring.jdbc.model.Employee;

public class EmployeeDAOJDBCTemplateImpl implements EmployeeDAO {

	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void save(Employee employee) {
		String query = "INSERT INTO EMPLOYEE(Id,Fname,Lname,Email)" + "values(?,?,?,?)";

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		Object[] args = new Object[] { employee.getId(), employee.getFname(), employee.getLname(),
				employee.getEmail() };

		int out = jdbcTemplate.update(query, args);

		if (out != 0) {
			System.out.println("Employee saved with id=" + employee.getId());
		} else
			System.out.println("Employee save failed with id=" + employee.getId());
	}

	public Employee getById(String id) {
		String query = "SELECT * FROM EMPLOYEE WHERE Id = ?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		// using RowMapper anonymous class, we can create a separate RowMapper for reuse
		Employee emp = jdbcTemplate.queryForObject(query, new Object[] { id }, new RowMapper<Employee>() {

			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
				Employee emp = new Employee();
				emp.setId(rs.getString("Id"));
				emp.setFname(rs.getString("Fname"));
				emp.setLname(rs.getString("Lname"));
				emp.setEmail(rs.getString("Email"));
				return emp;
			}
		});

		return emp;
	}

	public void update(Employee employee) {
		String query = "UPDATE EMPLOYEE SET Fname=?, Lname=?, Email=? " + "WHERE Id=?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		Object[] args = new Object[] { employee.getFname(), employee.getLname(), employee.getEmail(),
				employee.getId() };

		int out = jdbcTemplate.update(query, args);
		if (out != 0) {
			System.out.println("Employee updated with id=" + employee.getId());
		} else
			System.out.println("No Employee found with id=" + employee.getId());
	}

	public void deleteById(String id) {

		String query = "DELETE FROM EMPLOYEE WHERE Id=?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		int out = jdbcTemplate.update(query, id);
		if (out != 0) {
			System.out.println("Employee deleted with id=" + id);
		} else
			System.out.println("No Employee found with id=" + id);
	}

	public List<Employee> getAll() {
		String query = "SELECT * FROM EMPLOYEE";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Employee> empList = new ArrayList<Employee>();

		List<Map<String, Object>> empRows = jdbcTemplate.queryForList(query);

		for (Map<String, Object> empRow : empRows) {
			Employee emp = new Employee();
			emp.setId(String.valueOf(empRow.get("Id")));
			emp.setFname(String.valueOf(empRow.get("Fname")));
			emp.setLname(String.valueOf(empRow.get("Lname")));
			emp.setEmail(String.valueOf(empRow.get("Email")));

			empList.add(emp);
		}
		return empList;
	}
}