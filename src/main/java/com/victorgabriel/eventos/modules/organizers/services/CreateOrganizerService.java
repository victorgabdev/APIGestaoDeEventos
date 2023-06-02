package com.victorgabriel.eventos.modules.organizers.services;

import com.victorgabriel.eventos.modules.organizers.entities.Organizer;
import com.victorgabriel.eventos.modules.organizers.repositories.IOrganizerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateOrganizerService {

    @Autowired
    private IOrganizerRepository organizerRepository;

    public Organizer execute(Organizer organizer) {
        Organizer existOrganizer = this.organizerRepository.findByEmail(organizer.getEmail());
        if(existOrganizer != null) throw new Error("Organizer Already Exists");

        return this.organizerRepository.save(organizer);
    }
}
