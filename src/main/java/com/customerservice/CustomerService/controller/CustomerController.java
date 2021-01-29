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

    CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/api/customers")
    public List<Customer> getCustomers() throws IOException {
        //System.out.print(customerService.getCustomers());
        return  customerService.getCustomers();
    }

    @GetMapping("/api/customers/{id}")
    public Customer getCustomerById(@PathVariable String id) throws IOException {
        return  customerService.getCustomerById(id);
    }



}
