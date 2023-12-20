package com.example.demojspservlet.service;

import com.example.demojspservlet.entity.Employee;

import java.util.List;

public class EmployeeService implements IEmployeeService{
    @Override
    public List<Employee> findAll() {
        return null;
    }

    @Override
    public Employee findByName() {
        return null;
    }

    @Override
    public boolean addEmployeeInformation() {
        return false;
    }

    @Override
    public boolean editEmployeeInformation() {
        return false;
    }

    @Override
    public boolean removeEmployeeInformation() {
        return false;
    }
}
