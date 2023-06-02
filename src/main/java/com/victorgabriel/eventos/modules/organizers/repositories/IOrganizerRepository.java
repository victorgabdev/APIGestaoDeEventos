package com.victorgabriel.eventos.modules.organizers.repositories;

import com.victorgabriel.eventos.modules.organizers.entities.Organizer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IOrganizerRepository extends JpaRepository<Organizer, UUID> {
}
