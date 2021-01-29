package com.customerservice.CustomerService.service;

import com.customerservice.CustomerService.model.Customer;
import com.customerservice.CustomerService.repository.CustomerRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getCustomers() {
        System.out.println(customerRepository.findAll());
        return customerRepository.findAll();
    }

    public Customer getCustomerById(String id) {
        return null;
    }


}
