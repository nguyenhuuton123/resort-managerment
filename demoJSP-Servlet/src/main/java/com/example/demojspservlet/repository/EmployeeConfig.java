package com.example.demojspservlet.repository;

import com.example.demojspservlet.entity.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class EmployeeConfig implements IEmployeeDao{
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private final String SELECT_ALL = "SELECT * FROM employee";
    private final String SELECT_BY_ID = "SELECT * FROM employee WHERE id = ?";
    @Override
    public List<Employee> findAll() {
        return null;
    }

    @Override
    public Employee findById(int id) {
        return null;
    }

    @Override
    public boolean addEmployeeInformation(Employee employee) {
        return false;
    }

    @Override
    public boolean editEmployeeInformation(int id) {
        return false;
    }

    @Override
    public boolean removeEmployeeInformation(int id) {
        return false;
    }
}
