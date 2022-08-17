package com.example.businessmeetmanagement.services;

import com.example.businessmeetmanagement.dto.EventDto;

import java.util.List;

public interface EventService {
    EventDto addEvent(EventDto event);
    EventDto getEvent(int eventId);
    List<EventDto> getAllEventByUserId(long userId);
    List<EventDto> getAllEvents();
    EventDto editEvent(int eventId,EventDto event);
    void deleteEvent(int eventId);
}
