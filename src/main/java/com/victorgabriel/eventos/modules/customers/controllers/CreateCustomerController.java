package com.victorgabriel.eventos.modules.customers.controllers;

import com.victorgabriel.eventos.modules.customers.entities.Customer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CreateCustomerController {

    @RequestMapping("/")
    public Customer handle(@RequestBody Customer customer) {
        return customer;
    }
}
