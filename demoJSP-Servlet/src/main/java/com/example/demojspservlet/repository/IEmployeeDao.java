package com.example.demojspservlet.repository;

import com.example.demojspservlet.entity.Employee;

import java.util.List;

public interface IEmployeeDao {
    List<Employee> findAll();

    Employee findById(int id);

    boolean addEmployeeInformation(Employee employee);

    boolean editEmployeeInformation(int id);

    boolean removeEmployeeInformation(int id);
}
