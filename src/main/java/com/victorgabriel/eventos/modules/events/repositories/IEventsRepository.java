package com.victorgabriel.eventos.modules.events.repositories;

import com.victorgabriel.eventos.modules.events.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IEventsRepository extends JpaRepository<Event, UUID> {
}
