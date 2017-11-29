package com.codecool.spring.sample.service;

import com.codecool.spring.sample.model.Customer;
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
