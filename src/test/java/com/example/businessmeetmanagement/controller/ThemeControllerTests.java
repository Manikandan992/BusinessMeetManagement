package com.example.businessmeetmanagement.controller;

import com.example.businessmeetmanagement.controllers.ThemeController;
import com.example.businessmeetmanagement.dto.ThemeDto;
import com.example.businessmeetmanagement.services.ThemeService;
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
public class ThemeControllerTests {
    @InjectMocks
    ThemeController themeController;
    @Mock
    ThemeService themeService;
    ObjectMapper objectMapper=new ObjectMapper();
    ObjectWriter objectWriter=objectMapper.writer();
    private MockMvc mockMvc;
    ThemeDto themeDto1=new ThemeDto(1,"Fresher's Meet","12-8-90","Freshers are good",8000);
    ThemeDto themeDto2=new ThemeDto(2,"Orientation Meet","12-08-2020","Orientation is a backbone",9000);
    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        this.mockMvc= MockMvcBuilders.standaloneSetup(themeController).build();
    }
    @Test
    @Order(1)
    public void test_addFoodMenu(){
        String content;
        ThemeDto output=themeDto1;
        try{
            content=objectWriter.writeValueAsString(themeDto1);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        MockHttpServletRequestBuilder mockRequest= MockMvcRequestBuilders
                .post("/admin/addTheme/")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("utf-8")
                .content(content);
        try{
            mockMvc.perform(mockRequest)
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andDo(MockMvcResultHandlers.print());
            Assert.assertEquals(themeDto1,output);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    @Order(2)
    public void test_getThemes() throws Exception {
        List<ThemeDto> themeList=new ArrayList<>(Arrays.asList(themeDto1,themeDto2));
        Mockito.when(themeService.getThemes()).thenReturn(themeList);
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/admin/themes")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$",hasSize(2)))
                .andDo(MockMvcResultHandlers.print());
    }
    @Test
    @Order(3)
    public void test_getTheme() throws Exception {
        int id=1;
        Mockito.when(themeService.getTheme(id)).thenReturn(themeDto1);
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/admin/theme/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.themeName").value("Fresher's Meet"));
    }
    @Test
    @Order(4)
    public void test_updateTheme() throws Exception {
        int id=1;
        String content;
        try{
            content=objectWriter.writeValueAsString(themeDto1);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        MockHttpServletRequestBuilder mockRequest=MockMvcRequestBuilders
                .put("/admin/editTheme/1")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .characterEncoding("utf-8")
                .content(content);
        mockMvc.perform(mockRequest)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
    @Test
    @Order(5)
    public void test_deleteTheme() throws Exception {
        int id=1;

        MockHttpServletRequestBuilder mockRequest=MockMvcRequestBuilders
                .delete("/admin/deleteTheme/1")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);
        mockMvc.perform(mockRequest)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());

    }
}
