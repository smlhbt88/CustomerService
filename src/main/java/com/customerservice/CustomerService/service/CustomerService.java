package com.customerservice.CustomerService.service;

import com.customerservice.CustomerService.model.Customer;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    String customersJsonPath = "src/test/data/customers.json";
    String customerJsonPath = "src/test/data/existingCustomer.json";

    public List<Customer> getCustomers() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        File customersFile = new File(customersJsonPath);
        return mapper.readValue(customersFile, new TypeReference<ArrayList<Customer>>() {});
    }

    public Customer getCustomersById(String id) throws IOException {
        for(Customer customer : getCustomers()){
            if(customer.getId().equals(id)){
                return customer;
            }
        }
        return null;
    }
}
