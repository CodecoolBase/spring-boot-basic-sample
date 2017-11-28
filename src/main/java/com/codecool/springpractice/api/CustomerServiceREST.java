package com.codecool.springpractice.api;

import com.codecool.springpractice.model.Customer;
import com.codecool.springpractice.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Use code like this to make an API, for e.g. mobile clients, AJAX calls,..

// A @Controller where requests return plain strings.
// This is a "subannotation" of @Controller.
@RestController
public class CustomerServiceREST {

    private CustomerService customerService;


    public CustomerServiceREST(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/api/customers")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        return new ResponseEntity(customerService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/api/customers/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable("id") Long id) {
        String result = "";
        Customer customer = customerService.findById(id);
        if (customer == null) {
            return new ResponseEntity("No Customer found for ID " + id, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(customer, HttpStatus.OK);
    }
}
