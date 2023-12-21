package com.example.repository;

import com.entity.Employee;

import java.util.List;

public interface IEmployeeDao {
    List<Employee> findAll();

    Employee findById(int key);

    boolean addEmployeeInformation(Employee employee);

    boolean editEmployeeInformation(int id, Employee employee);

    boolean removeEmployeeInformation(int id);
}
