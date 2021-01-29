package com.customerservice.CustomerService.repository;

import com.customerservice.CustomerService.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
