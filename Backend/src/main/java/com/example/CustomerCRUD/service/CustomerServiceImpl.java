package com.example.CustomerCRUD.service;

import com.example.CustomerCRUD.Repository.CustomerRepo;
import com.example.CustomerCRUD.exception.ResourceNotFoundException;
import com.example.CustomerCRUD.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    CustomerRepo customerRepo;

    @Override
    public List<Customer> getAllCustomer() {
        List<Customer> allCustomers = customerRepo.findAll();
        return allCustomers;
    }

    @Override
    public Customer addCustomer(Customer customer) {
        return customerRepo.save(customer);
    }

    @Override
    public Customer getCustomerById(Long id) {
        return customerRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer doesn't exist with id: " + id));
    }

    @Override
    public Customer updateCustomerById(Long id, Customer customer) {
        Customer originalCustomer = customerRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id:" + id));
        if(originalCustomer != null){
            originalCustomer.setFname(customer.getFname());
            originalCustomer.setLname(customer.getLname());
            originalCustomer.setEmail(customer.getEmail());
            originalCustomer.setPassword(customer.getPassword());
            return customerRepo.save(originalCustomer);
        }
        return null;
    }


        @Override
        public void deleteCustomerById(Long id) {
            Customer customer = customerRepo.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Customer does not exist with id: " + id));

            customerRepo.delete(customer);
    }

}
