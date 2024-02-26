package com.example.model.repository;

import com.example.model.entity.Employee;

import java.util.List;

public interface IEmployeeDao {
    List<Employee> findAll();

    Employee findById(int key);

    boolean addEmployeeInformation(Employee employee);

    boolean editEmployeeInformation(int id, Employee employee);

    boolean removeEmployeeInformation(int id);
}
