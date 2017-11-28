package com.codecool.springpractice.service;

import com.codecool.springpractice.model.Customer;
import com.codecool.springpractice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// Used to hold DB access methods. Subannotation of @Component
// The extra functionality compared to @Component is that any platform specific exceptions are caught and then
// rethrown as one of Spring’s unchecked data access exceptions.
@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public void deleteAll() {
        customerRepository.deleteAll();
    }

    public void saveCustomer(Customer entity) {
        customerRepository.save(entity);
    }

    public Customer findById(Long id) {
        return customerRepository.findOne(id);
    }

    public List<Customer> findByLastName(String name) {
        return customerRepository.findByLastName(name);
    }
}
