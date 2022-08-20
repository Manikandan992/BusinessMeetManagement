package com.example.businessmeetmanagement.controllers;

import com.example.businessmeetmanagement.dto.EventDto;
import com.example.businessmeetmanagement.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class EventController {

    @Autowired
    private EventService eventService;

    @PostMapping("/user/bookEvent")
    public ResponseEntity<EventDto> addEvent(@RequestBody EventDto event){
        return ResponseEntity.ok(eventService.addEvent(event));
    }

    @GetMapping("/user/view-booked-event/{id}")
    public ResponseEntity<EventDto> getEvent(@PathVariable("id") int eventId){
        return ResponseEntity.ok(eventService.getEvent(eventId));
    }
    @GetMapping("/admin/view-booked-event")
    public ResponseEntity<List<EventDto>> getAllEvents(){
        List<EventDto> events = eventService.getAllEvents();
        return new ResponseEntity<>(events, HttpStatus.OK);
    }
    @PutMapping("/view-booked-event/edit-view-booked-event/{id}")
    public ResponseEntity<EventDto> editEvent(@PathVariable("id") int eventId,@RequestBody EventDto event){
        return ResponseEntity.ok(eventService.editEvent(eventId,event));
    }
    @DeleteMapping("user/view-booked-event/delete-view-booked-event/{id}")
    public void deleteEvent(@PathVariable("id") int eventId){
        eventService.deleteEvent(eventId);
    }

    @GetMapping("user/view-booked-events/{id}")
    public ResponseEntity<List<EventDto>> getAllEventsByUserId(@PathVariable("id") long userId){
        List<EventDto> events = eventService.getAllEventByUserId(userId);
        return new ResponseEntity<>(events,HttpStatus.OK);
    }
}
