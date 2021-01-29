package com.customerservice.CustomerService.service;

import com.customerservice.CustomerService.model.Customer;
import com.customerservice.CustomerService.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {

    @Mock
    CustomerRepository customerRepository;

    @InjectMocks
    CustomerService customerService;

    @Test
    void getCustomers() {
        when(customerRepository.findAll()).thenReturn(new ArrayList<>());
        List<Customer> actualListOfCustomers = customerService.getCustomers();
        verify(customerRepository).findAll();
        assertThat(actualListOfCustomers).isEmpty();
    }
    @Test
    void addCustomer(){
        Customer customer = new Customer("Salvator", "Di'Mario", "45 Carver Ave, Midland, TX 70134", "510-555-7863");
        when(customerRepository.save(customer)).thenReturn(customer);
        Customer actualCustomer = customerService.addCustomer(customer);
        verify(customerRepository).save(customer);
        assertThat(actualCustomer).isEqualTo(customer);
    }
}