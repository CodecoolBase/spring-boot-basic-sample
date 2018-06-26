package com.codecool.spring.sample.controller;

import com.codecool.spring.sample.model.Customer;
import com.codecool.spring.sample.repository.CustomerRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CustomerController {

    private CustomerRepository customerRepository;

    public CustomerController(CustomerRepository service) {
        this.customerRepository = service;
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public String addCustomer(Customer customer) {
        customerRepository.save(customer);
        return "customers";
    }

    @GetMapping("/customers")
    public String listCustomersView(Model model) {
        model.addAttribute("customers", getAllCustomers());
        return "customers";
    }

    @GetMapping("/addcustomer")
    public String addCustomerForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "addcustomer";
    }

    @PostMapping("/addcustomer")
    public String addCustomerForm(@ModelAttribute Customer customer) {
        addCustomer(customer);
        return "redirect:customers";
    }
}
