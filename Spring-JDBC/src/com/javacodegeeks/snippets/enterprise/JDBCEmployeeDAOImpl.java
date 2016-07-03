package com.javacodegeeks.snippets.enterprise;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class JDBCEmployeeDAOImpl implements JDBCEmployeeDAO {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void insert(Employee employee) {
		String sql = "INSERT INTO EMPLOYEE "
				+ "(ID, NAME, AGE) VALUES (?, ?, ?)";
		jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(
				sql,
				new Object[] { employee.getId(), employee.getName(),
						employee.getAge() });
	}

	@SuppressWarnings({ "unchecked" })
	public Employee findById(int id) {
		String sql = "SELECT * FROM EMPLOYEE WHERE ID = ?";
		jdbcTemplate = new JdbcTemplate(dataSource);
		Employee employee = (Employee) jdbcTemplate.queryForObject(sql,
				new Object[] { id }, new EmployeeRowMapper());
		return employee;
	}

	@SuppressWarnings("rawtypes")
	public List<Employee> findAll() {
		jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "SELECT * FROM EMPLOYEE";
		List<Employee> employees = new ArrayList<Employee>();
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
		for (Map row : rows) {
			Employee employee = new Employee();
			employee.setId(Integer.parseInt(String.valueOf(row.get("ID"))));
			employee.setName((String) row.get("NAME"));
			employee.setAge(Integer.parseInt(String.valueOf(row.get("AGE"))));
			employees.add(employee);
		}
		return employees;
	}
}
