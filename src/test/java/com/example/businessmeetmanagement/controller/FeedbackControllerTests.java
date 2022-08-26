package com.example.businessmeetmanagement.controller;

import com.example.businessmeetmanagement.controllers.FeedbackController;
import com.example.businessmeetmanagement.dto.FeedbackDto;
import com.example.businessmeetmanagement.services.FeedbackService;
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
public class FeedbackControllerTests {
    @InjectMocks
    FeedbackController feedbackController;
    @Mock
    FeedbackService feedbackService;
    ObjectMapper objectMapper=new ObjectMapper();
    ObjectWriter objectWriter=objectMapper.writer();
    private MockMvc mockMvc;
    FeedbackDto feedbackDto1=new FeedbackDto(1,"Magic","12-8-90");
    FeedbackDto feedbackDto2=new FeedbackDto(2,"Comedy","12-4-20");
    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        this.mockMvc= MockMvcBuilders.standaloneSetup(feedbackController).build();
    }
    @Test
    @Order(1)
    public void test_addFeedback(){
        String content;
        FeedbackDto output=feedbackDto1;
        try{
            content=objectWriter.writeValueAsString(feedbackDto1);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        MockHttpServletRequestBuilder mockRequest= MockMvcRequestBuilders
                .post("/user/add-feedback")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("utf-8")
                .content(content);
        try{
            mockMvc.perform(mockRequest)
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andDo(MockMvcResultHandlers.print());
            Assert.assertEquals(feedbackDto1,output);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    @Order(2)
    public void test_getFeedbacks() throws Exception {
        List<FeedbackDto> feedbackList=new ArrayList<>(Arrays.asList(feedbackDto1,feedbackDto2));
        Mockito.when(feedbackService.getFeedbacks()).thenReturn(feedbackList);
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/user/feedback","admin/feedback")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$",hasSize(2)))
                .andDo(MockMvcResultHandlers.print());
    }


}

