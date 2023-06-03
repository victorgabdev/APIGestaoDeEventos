package com.victorgabriel.eventos.modules.events.entities;

import com.victorgabriel.eventos.modules.organizers.entities.Organizer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "events")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Event {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    private String address;
    private LocalDateTime startAt;
    private LocalDateTime endAt;
    private String description;
    private BigDecimal price;
    private int quantity;
    private int availableQuantity;
    private LocalDateTime createdAt;

    @ManyToOne()
    @JoinColumn(name = "organizer_id")
    private Organizer organizer;

    @Column(name = "organizer_id")
    private UUID organizerId;
}
