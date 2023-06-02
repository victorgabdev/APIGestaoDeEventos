package com.victorgabriel.eventos.modules.organizers.entities;

import jdk.jfr.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "organizers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Organizer {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    private String email;
    private String password;
    private String adress;
    private String responsible;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
