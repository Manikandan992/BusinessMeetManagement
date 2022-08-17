package com.example.businessmeetmanagement.services.impl;

import com.example.businessmeetmanagement.dto.EventDto;
import com.example.businessmeetmanagement.entities.Event;
import com.example.businessmeetmanagement.exceptions.ResourceNotFoundException;
import com.example.businessmeetmanagement.mapper.EventMapper;
import com.example.businessmeetmanagement.repositories.EventRepository;
import com.example.businessmeetmanagement.services.EventService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@Slf4j
public class EventServiceImpl implements EventService {
    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private EventMapper mapper;

    @Override
    public EventDto addEvent(EventDto event) {
        Event event1 = mapper.toEvent(event);
        event1=eventRepository.save(event1);
        log.info("Event Added");
        return mapper.toEventDto(event1);
    }

    @Override
    public EventDto getEvent(int eventId) {
        return mapper.toEventDto(eventRepository.findById(eventId)
                .orElseThrow(()->new ResourceNotFoundException("Event not Found")));
    }

    @Override
    public List<EventDto> getAllEventByUserId(long userId) {
        return mapper.toEventDtos(eventRepository.findAllByUserId(userId));
    }

    @Override
    public List<EventDto> getAllEvents() {
        return mapper.toEventDtos(eventRepository.findAll());
    }

    @Override
    public EventDto editEvent(int eventId, EventDto event) {
        EventDto update=mapper.toEventDto(eventRepository.findById(eventId).orElseThrow(()->new ResourceNotFoundException("Event not Found")));
        update.setEventName(event.getEventName());
        update.setApplicantName(event.getApplicantName());
        update.setApplicantAddress(event.getApplicantAddress());
        update.setApplicantMobile(event.getApplicantMobile());
        update.setApplicantEmail(event.getApplicantEmail());
        update.setLocation(event.getLocation());
        update.setEventDate(event.getEventDate());
        update.setEventTime(event.getEventTime());
        update.setNoOfPeople(event.getNoOfPeople());
        update.setSelectItem(event.getSelectItem());
        update.setQuantity(event.getQuantity());
        update.setSelectAddOnsCategory(event.getSelectAddOnsCategory());
        Event event1 =mapper.toEvent(update);
        event1=eventRepository.save(event1);
        log.info("Event modified");
        return mapper.toEventDto(event1);
    }

    @Override
    public void deleteEvent(int eventId) {
        eventRepository.deleteById(eventId);
        log.warn("Event Deleted");

    }
}
