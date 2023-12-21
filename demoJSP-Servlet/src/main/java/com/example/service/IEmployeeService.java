package com.example.service;

import com.entity.Employee;

import java.util.List;

public interface IEmployeeService {
    List<Employee> findAll();

    Employee findbyId(int id);

    boolean addEmployeeInformation(Employee employee);

    boolean editEmployeeInformation(int id, Employee employee);

    boolean removeEmployeeInformation(int id);
}
