package com.example.model.service;

import com.example.model.entity.Employee;
import com.example.model.repository.EmployeeConfig;
import com.example.model.repository.IEmployeeDao;

import java.util.List;

public class EmployeeService implements IEmployeeService {
    IEmployeeDao employeeDao = new EmployeeConfig();
    @Override
    public List<Employee> findAll() {
        return employeeDao.findAll() ;
    }

    @Override
    public Employee findbyId(int id) {
        return employeeDao.findById(id);
    }

    @Override
    public boolean addEmployeeInformation(Employee employee) {
        return employeeDao.addEmployeeInformation(employee);
    }

    @Override
    public boolean editEmployeeInformation(int id, Employee employee) {
        return employeeDao.editEmployeeInformation(id,employee);
    }

    @Override
    public boolean removeEmployeeInformation(int id) {
        return employeeDao.removeEmployeeInformation(id);
    }
}
