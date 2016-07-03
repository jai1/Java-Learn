package com.javacodegeeks.snippets.enterprise;

import java.util.List;

import com.javacodegeeks.snippets.enterprise.Employee;

public interface JDBCEmployeeDAO {
    public void insert(Employee employee);
    public Employee findById(int id);
    public List<Employee> findAll();
}
