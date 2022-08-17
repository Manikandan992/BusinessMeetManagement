package com.example.businessmeetmanagement.mapper;

import com.example.businessmeetmanagement.dto.EventDto;
import com.example.businessmeetmanagement.entities.Event;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class EventMapper {

    public Event toEvent(EventDto eventDto){
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return mapper.map(eventDto,Event.class);
    }
    public EventDto toEventDto(Event event){
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return mapper.map(event,EventDto.class);
    }
    public List<EventDto> toEventDtos(List<Event> events){
        ModelMapper mapper = new ModelMapper();
        return Arrays.asList(mapper.map(events,EventDto[].class));
    }
}