package com.codecool.springpractice.service;

import com.codecool.springpractice.model.Customer;
import com.codecool.springpractice.repository.CustomerRepository;
import org.springframework.stereotype.Component;

@Component
public class InitializerBean {

    public InitializerBean(CustomerService customerService) {
        customerService.saveCustomer(new Customer("Jack", "Smith"));
        customerService.saveCustomer(new Customer("Adam", "Johnson"));
        customerService.saveCustomer(new Customer("Kim", "Smith"));
        customerService.saveCustomer(new Customer("David", "Williams"));
        customerService.saveCustomer(new Customer("Peter", "Davis"));
    }
}
