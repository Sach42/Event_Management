package com.sachin.Event.Management.controller;

import com.sachin.Event.Management.Model.Event;
import com.sachin.Event.Management.Service.EventService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {
    @Autowired
    EventService eventService;

    @PostMapping
    public String AddEvent(@Valid @RequestBody Event event){
        return eventService.AddEvent(event);
    }

    @PutMapping("/{id}")
    public String updateEvent(@PathVariable Long id, @Valid @RequestBody Event event) {
        return eventService.updateEvent(id, event);
    }

    @DeleteMapping("/{id}")
    public String deleteEvent(@PathVariable Long id) {
        return eventService.deleteEvent(id);
    }

    @GetMapping
    public List<Event> getAllEventsByDate(@RequestParam LocalDate date) {
        return eventService.getAllEventsByDate(date);
    }

}
