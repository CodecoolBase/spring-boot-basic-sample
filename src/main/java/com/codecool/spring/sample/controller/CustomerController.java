package com.codecool.spring.sample.controller;

import com.codecool.spring.sample.model.Customer;
import com.codecool.spring.sample.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    CustomerService customerService;

    public List<Customer> getAllCustomers() {
        return customerService.findAll();
    }

    public String addCustomer(Customer customer) {
        customerService.saveCustomer(customer);
        return "customers";
    }

    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public String listCustomersView(Model model) {
        model.addAttribute("customers", getAllCustomers());
        return "customers";
    }

    @RequestMapping(value = "/addcustomer", method = RequestMethod.GET)
    public String addCustomerForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "addcustomer";
    }

    @RequestMapping(value = "/addcustomer", method = RequestMethod.POST)
    public String addCustomerForm(@ModelAttribute Customer customer) {
        addCustomer(customer);
        return "redirect:customers";
    }
}
