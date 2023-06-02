package com.victorgabriel.eventos.modules.customers.services;

import com.victorgabriel.eventos.modules.customers.entities.Customer;
import com.victorgabriel.eventos.modules.customers.repositories.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CreateCustomerService {

    // A camada de services é aonde ficam as regras de negócios e validações
    // Chamada para a camada de repository (banco de dados)

    @Autowired
    private ICustomerRepository customerRepository;

    public Customer execute(Customer customer) {
        var customerExists = this.customerRepository.findByEmail(customer.getEmail());
        if(customerExists != null) throw new Error("Customer Already Exists");

        var customerCreated =  this.customerRepository.save(customer);
        return customerCreated;
    }
}
