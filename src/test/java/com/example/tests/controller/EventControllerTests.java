package com.example.tests.controller;

import com.example.businessmeetmanagement.controllers.AddonController;
import com.example.businessmeetmanagement.controllers.EventController;
import com.example.businessmeetmanagement.dto.AddonDto;
import com.example.businessmeetmanagement.dto.EventDto;
import com.example.businessmeetmanagement.services.AddonService;
import com.example.businessmeetmanagement.services.EventService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
public class EventControllerTests {
    @InjectMocks
    EventController eventController;
    @Mock
    EventService eventService;
    ObjectMapper objectMapper=new ObjectMapper();
    ObjectWriter objectWriter=objectMapper.writer();
    private MockMvc mockMvc;
     EventDto eventDto1=new EventDto(1,"Fresher's Day","Mohammed","Coimbatore","12-8-2022","9384784053","abc@gmail.com","12:00",10,500,200,8000, 2);
     EventDto eventDto2=new EventDto(2,"Orientation Day","Taha","Chennai","14-8-2022","9904084858","taha@gmail.com","10:00",50,100,200,8000, 3);
    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        this.mockMvc= MockMvcBuilders.standaloneSetup(eventController).build();
    }
    @Test
    @Order(1)
    public void test_addEvent(){
        String content;
        try{
            content=objectWriter.writeValueAsString(eventDto1);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        MockHttpServletRequestBuilder mockRequest= MockMvcRequestBuilders
                .post("/user/bookEvent")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("utf-8")
                .content(content);
        try{
            mockMvc.perform(mockRequest)
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andDo(MockMvcResultHandlers.print());
            Assert.assertEquals(eventDto1,eventDto1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    @Order(2)
    public void test_getAllEvents() throws Exception {
        List<EventDto> eventList=new ArrayList<>(Arrays.asList(eventDto1,eventDto2));
        Mockito.when(eventService.getAllEvents()).thenReturn(eventList);
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/admin/view-booked-event")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$",hasSize(2)))
                .andDo(MockMvcResultHandlers.print());
    }
    @Test
    @Order(3)
    public void test_getEvent() throws Exception {
        int eventId=1;
        Mockito.when(eventService.getEvent(eventId)).thenReturn(eventDto1);
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/user/view-booked-event/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.eventName").value("Fresher's Day"));
    }
    @Test
    @Order(4)
    public void test_getAllEventsByUserId() throws Exception {
        long userId = 2;
        List<EventDto> eventList = new ArrayList<>(Arrays.asList(eventDto1));
        Mockito.when(eventService.getAllEventByUserId(userId)).thenReturn(eventList);
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/user/view-booked-events/2")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].eventName").value("Fresher's Day"));
    }
    @Test
    @Order(5)
    public void test_editEvent() throws Exception {
        int eventId=1;
        String content;
        try{
            content=objectWriter.writeValueAsString(eventDto1);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        MockHttpServletRequestBuilder mockRequest=MockMvcRequestBuilders
                .put("/view-booked-event/edit-view-booked-event/1")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .characterEncoding("utf-8")
                .content(content);
        mockMvc.perform(mockRequest)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
    @Test
    @Order(6)
    public void test_deleteEvent() throws Exception {
        int eventId=1;
        MockHttpServletRequestBuilder mockRequest=MockMvcRequestBuilders
                .delete("/user/view-booked-event/delete-view-booked-event/1")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);
        mockMvc.perform(mockRequest)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

}
