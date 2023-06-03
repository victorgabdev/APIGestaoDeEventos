package com.victorgabriel.eventos.modules.events.services;

import com.victorgabriel.eventos.modules.events.entities.Event;
import com.victorgabriel.eventos.modules.events.repositories.IEventsRepository;
import com.victorgabriel.eventos.modules.organizers.entities.Organizer;
import com.victorgabriel.eventos.modules.organizers.repositories.IOrganizerRepository;
import com.victorgabriel.eventos.shared.exceptions.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class CreateEventService {

    @Autowired
    private IEventsRepository eventsRepository;

    @Autowired
    private IOrganizerRepository organizerRepository;

    public Event execute(Event event) {
        //validar se organizer existe
        var existsOrganizerOfEvent = this.organizerRepository.findById(event.getOrganizerId());
        if(existsOrganizerOfEvent == null) throw new CustomException("Organizer not Exists", HttpStatus.NOT_FOUND);
        if(event.getAvailableQuantity() == 0) event.setAvailableQuantity(event.getQuantity());

        return this.eventsRepository.save(event);
    }
}
