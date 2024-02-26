package com.example.model.service;

import com.example.model.entity.Customer;

import java.util.List;

public interface IsExist {
    boolean isExist(List<Customer> customerList, Customer customer);
}
