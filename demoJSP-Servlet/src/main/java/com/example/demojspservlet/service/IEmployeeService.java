package com.example.demojspservlet.service;

import com.example.demojspservlet.entity.Employee;

import java.util.List;

public interface IEmployeeService {
    List<Employee> findAll();

    Employee findByName();

    boolean addEmployeeInformation();

    boolean editEmployeeInformation();

    boolean removeEmployeeInformation();
}
