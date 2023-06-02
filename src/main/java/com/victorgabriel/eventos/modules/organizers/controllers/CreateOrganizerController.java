package com.victorgabriel.eventos.modules.organizers.controllers;

import com.victorgabriel.eventos.modules.organizers.entities.Organizer;
import com.victorgabriel.eventos.modules.organizers.services.CreateOrganizerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/organizers")
public class CreateOrganizerController {

    @Autowired
    private CreateOrganizerService createOrganizerService;

    @PostMapping("/")
    public Organizer handle(@RequestBody Organizer organizer) {
        return this.createOrganizerService.execute(organizer);
    }
}
