package com.sachin.Event.Management.Service;

import com.sachin.Event.Management.Model.Event;
import com.sachin.Event.Management.Repository.IEventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class EventService {
    @Autowired
    IEventRepo eventRepo;

    public String AddEvent(Event event) {
        eventRepo.save(event);
        return "event added";
    }

    public String updateEvent(Long id, Event event) {
        Optional<Event> optionalEvent = eventRepo.findById(id);
        if(optionalEvent.isPresent()){
            Event existingEvent = optionalEvent.get();
            existingEvent.setEventName(event.getEventName());
            existingEvent.setLocationOfEvent(event.getLocationOfEvent());
            existingEvent.setDate(event.getDate());
            existingEvent.setStartTime(event.getStartTime());
            existingEvent.setEndTime(event.getEndTime());
            eventRepo.save(existingEvent);
            return "Event updated successfully!";
        }else{
            return "event id not found";
        }
    }

    public String deleteEvent(Long id) {
        if(eventRepo.existsById(id)){
            eventRepo.deleteById(id);
            return "event deleted";
        }else{
            return "event id not found";
        }
    }

    public List<Event> getAllEventsByDate(LocalDate date) {
        return eventRepo.findAllByDate(date);
    }
}
