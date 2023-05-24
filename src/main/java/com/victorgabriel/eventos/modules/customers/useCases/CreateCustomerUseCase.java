package com.victorgabriel.eventos.modules.customers.useCases;

import com.victorgabriel.eventos.modules.customers.entities.Customer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CreateCustomerUseCase {

    private List<Customer> customers = new ArrayList<>();
    public Customer execute(Customer customer) {
        var existCustomer = this.customers.stream().filter(c -> c.getEmail().equals(customer.getEmail()));
        if (existCustomer.findFirst().isPresent()) throw new Error("Customer already exists!");
        this.customers.add(customer);
        return customer;
    }
}
