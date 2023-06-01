package com.victorgabriel.eventos.modules.customers.services;

import com.victorgabriel.eventos.modules.customers.entities.Customer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CreateCustomerService {

    // A camada de services é aonde ficam as regras de negócios e validações
    // Chamada para a camada de repository (banco de dados)

    private List<Customer> customers = new ArrayList<>();
    public Customer execute(Customer customer) {
        var existCustomer = this.customers.stream().filter(c -> c.getEmail().equals(customer.getEmail()));
        if (existCustomer.findFirst().isPresent()) throw new Error("Customer already exists!");
        this.customers.add(customer);
        return customer;
    }
}
