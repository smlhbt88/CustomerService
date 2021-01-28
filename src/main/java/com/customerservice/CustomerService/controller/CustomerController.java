package com.customerservice.CustomerService.controller;

import com.customerservice.CustomerService.model.Customer;
import com.customerservice.CustomerService.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/api/customers")
    public List<Customer> getCustomers() throws IOException {
        return  customerService.getCustomers();
    }

    @GetMapping("/api/customers/{id}")
    public Customer getCustomersById(@PathVariable String id) throws IOException {
        System.out.println(customerService.getCustomersById(id));
        return  customerService.getCustomersById(id);
    }



}
