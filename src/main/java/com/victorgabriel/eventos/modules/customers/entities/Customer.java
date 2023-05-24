package com.victorgabriel.eventos.modules.customers.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data  // vai colocar getter and setter em todos os meus atributos
@AllArgsConstructor  // Criar um construtor com todos os atributos
@NoArgsConstructor  // Criar um construtor vazio
public class Customer {

    private UUID id;
    private String name;
    private String email;
    private String password;
    private String document;
    private String phone;

    public UUID getId() {
        return UUID.randomUUID();
    }
}