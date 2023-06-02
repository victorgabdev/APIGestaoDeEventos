package com.victorgabriel.eventos.modules.customers.repositories;

import com.victorgabriel.eventos.modules.customers.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ICustomerRepository extends JpaRepository<Customer, UUID> {
    Customer findByEmail(String email);
    // O proprio JPA cria esse metodo (Entretando precisa ser com um dos atributos da entidade
    // customer, o padrao é findBy[Atribbute]
}
