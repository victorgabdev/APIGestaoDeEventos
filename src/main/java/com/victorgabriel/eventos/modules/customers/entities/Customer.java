package com.victorgabriel.eventos.modules.customers.entities;

import com.victorgabriel.eventos.shared.entities.BaseEntityUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "customers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer extends BaseEntityUser {
    private String name;
    private String document;
    private String phone;

    @CreationTimestamp
    private LocalDateTime createdAt;
}