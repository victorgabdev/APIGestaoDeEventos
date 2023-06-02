package com.victorgabriel.eventos.modules.customers.repositories;

import com.victorgabriel.eventos.modules.customers.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

public interface ICustomerRepository extends JpaRepository<Customer, UUID> {
}
