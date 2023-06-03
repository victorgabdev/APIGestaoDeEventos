package com.victorgabriel.eventos.modules.events.controllers;

import com.victorgabriel.eventos.modules.events.entities.Event;
import com.victorgabriel.eventos.modules.events.services.CreateEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/events")
public class CreateEventController {

    @Autowired
    private CreateEventService createEventService;

    @PostMapping("/")
    public Event handle(@RequestBody Event event) {
        return this.createEventService.execute(event);
    }
}
