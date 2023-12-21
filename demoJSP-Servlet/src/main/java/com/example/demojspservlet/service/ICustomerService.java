package com.example.demojspservlet.service;

import com.example.entity.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();

    Customer findById(int id);

    boolean add(Customer customer);

    boolean edit(int id, Customer customer);

    boolean remove(int id);
}
