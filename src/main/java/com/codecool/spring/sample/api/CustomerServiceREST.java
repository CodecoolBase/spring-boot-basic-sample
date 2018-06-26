package com.codecool.spring.sample.api;

import com.codecool.spring.sample.model.Customer;
import com.codecool.spring.sample.repository.CustomerRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Use code like this to make an API, for e.g. mobile clients, AJAX calls,..

// A @Controller where requests return plain strings.
// This is a "subannotation" of @Controller.
@RestController
public class CustomerServiceREST {

    private CustomerRepository customerRepository;

    public CustomerServiceREST(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping("/api/customers")
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @GetMapping("/api/customers/{id}")
    public Customer getCustomerById(@PathVariable("id") Long id) {
        return customerRepository.findById(id).get();
    }
}
