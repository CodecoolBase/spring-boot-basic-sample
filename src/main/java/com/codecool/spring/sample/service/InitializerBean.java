package com.codecool.spring.sample.service;

import com.codecool.spring.sample.model.Customer;
import com.codecool.spring.sample.repository.CustomerRepository;
import org.springframework.stereotype.Component;

@Component
public class InitializerBean {

    public InitializerBean(CustomerRepository customerRepository) {
        customerRepository.save(new Customer("Jack", "Smith"));
        customerRepository.save(new Customer("Adam", "Johnson"));
        customerRepository.save(new Customer("Kim", "Smith"));
        customerRepository.save(new Customer("David", "Williams"));
        customerRepository.save(new Customer("Peter", "Davis"));
    }
}
