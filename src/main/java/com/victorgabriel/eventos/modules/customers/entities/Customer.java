package com.victorgabriel.eventos.modules.customers.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Data  // vai colocar getter and setter em todos os meus atributos
@AllArgsConstructor  // Criar um construtor com todos os atributos
@NoArgsConstructor  // Criar um construtor vazio
@Entity  // Bean para o Spring e para o jpa
@Table(name = "customers")  // Na tabela do databse esse será o name
public class Customer {

    @Id  // Esclarecendo a minha primary key
    @GeneratedValue(generator = "UUID")
    private UUID id;

    private String name;
    private String email;
    private String password;
    private String document;
    private String phone;

    @CreationTimestamp
    private LocalDateTime createdAt;
}