package com.example.CustomerCRUD.service;

import com.example.CustomerCRUD.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getAllCustomer();
    Customer addCustomer(Customer customer);
    Customer getCustomerById(Long id);
    Customer updateCustomerById(Long id, Customer customer);
    void deleteCustomerById(Long id);
}
