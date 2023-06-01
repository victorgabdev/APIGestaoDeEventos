package com.victorgabriel.eventos.modules.customers.controllers;

import com.victorgabriel.eventos.modules.customers.entities.Customer;
import com.victorgabriel.eventos.modules.customers.services.CreateCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CreateCustomerController {

    // Inversao de dependencia -> O proprio spring faz gerenciamento das classes que eu coloquei as anotations
    // injecao de dependencia -> Quem vai injetar as dependencias tambem é o spring

    @Autowired  // injecao de dependencia
    private CreateCustomerService createCustomerService;

    @RequestMapping("/")
    public Customer handle(@RequestBody Customer customer) {
        return this.createCustomerService.execute(customer);
    }
}
