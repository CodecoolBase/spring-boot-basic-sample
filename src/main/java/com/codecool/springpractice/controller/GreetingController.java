package com.codecool.springpractice.controller;

import com.codecool.springpractice.model.Customer;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// Use code like this to serve webpages for browsers.

@Controller
@Scope("session")
public class GreetingController {

    private Customer user = new Customer("World", "Hello");

    // This tells Thymeleaf how to fill the template.
    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("user", user);
    }

    // A sample how to return a template for a request. You can use the model parameter to
    // fill your template.
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String helloView() {
        return "hello"; // This returns a template in resources/template/hello.html
    }

    @RequestMapping(value = "/gimmeyourname", method = RequestMethod.GET)
    public String gimmeyournameView() {
        return "gimmeyourname";
    }

    @RequestMapping(value = "/gimmeyourname", method = RequestMethod.POST)
    public String gimmeyournameSubmit(@ModelAttribute Customer user) {
        this.user = user;
        return "redirect:hello";
    }
}
