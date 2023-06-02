package com.victorgabriel.eventos.modules.organizers.services;

import com.victorgabriel.eventos.modules.organizers.entities.Organizer;
import com.victorgabriel.eventos.modules.organizers.repositories.IOrganizerRepository;
import com.victorgabriel.eventos.shared.exceptions.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class CreateOrganizerService {

    @Autowired
    private IOrganizerRepository organizerRepository;

    public Organizer execute(Organizer organizer) {
        Organizer existOrganizer = this.organizerRepository.findByEmail(organizer.getEmail());
        if(existOrganizer != null) throw new CustomException("Organizer Already Exists", HttpStatus.CONFLICT);
        // 409

        return this.organizerRepository.save(organizer);
    }
}
