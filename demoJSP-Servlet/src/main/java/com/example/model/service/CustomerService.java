package com.example.model.service;

import com.example.model.entity.Customer;
import com.example.model.repository.ICustomerDao;
import com.example.model.repository.impl.CustomerDao;

import java.util.List;

public class CustomerService implements ICustomerService {
    private IsExist isCustomerExist = new IsCustomerExist();
    ICustomerDao customerDao = new CustomerDao();
    @Override
    public List<Customer> findAll() {
        return customerDao.findAll();
    }

    @Override
    public Customer findById(int id) {
        return customerDao.findById(id);
    }

    @Override
    public boolean add(Customer customer) {
        if (!isCustomerExist.isExist(findAll(), customer)) {
            return customerDao.add(customer);
        }return false;
    }
    @Override
    public boolean edit(int id, Customer customer) {
        return false;
    }

    @Override
    public boolean remove(int id) {
        return false;
    }
}
