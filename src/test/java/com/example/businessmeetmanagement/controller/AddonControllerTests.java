package com.example.businessmeetmanagement.controller;

import com.example.businessmeetmanagement.controllers.AddonController;
import com.example.businessmeetmanagement.dto.AddonDto;
import com.example.businessmeetmanagement.services.AddonService;
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
public class AddonControllerTests {
@InjectMocks
    AddonController addonController;
@Mock
    AddonService addonService;
    ObjectMapper objectMapper=new ObjectMapper();
    ObjectWriter objectWriter=objectMapper.writer();
    private MockMvc mockMvc;
    AddonDto addonDto1=new AddonDto(1,"Magic","12-8-90",90);
    AddonDto addonDto2=new AddonDto(2,"Comedy","12-4-20",80);
    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        this.mockMvc= MockMvcBuilders.standaloneSetup(addonController).build();
    }
    @Test
    @Order(1)
    public void test_addAddon(){
        String content;
        AddonDto output =addonDto1;
        try{
            content=objectWriter.writeValueAsString(addonDto1);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        MockHttpServletRequestBuilder mockRequest= MockMvcRequestBuilders
                .post("/admin/addAddon/")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("utf-8")
                .content(content);
        try{
            mockMvc.perform(mockRequest)
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andDo(MockMvcResultHandlers.print());
            Assert.assertEquals(addonDto1,output);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    @Order(2)
    public void test_getAddons() throws Exception {
        List<AddonDto> addonList=new ArrayList<>(Arrays.asList(addonDto1,addonDto2));
        Mockito.when(addonService.getAddons()).thenReturn(addonList);
        mockMvc.perform(MockMvcRequestBuilders
                .get("/admin/addons")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$",hasSize(2)))
                .andDo(MockMvcResultHandlers.print());
    }
    @Test
    @Order(3)
    public void test_getAddon() throws Exception {
        int id=1;
        Mockito.when(addonService.getAddon(id)).thenReturn(addonDto1);
        mockMvc.perform(MockMvcRequestBuilders
                .get("/admin/addon/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.addonName").value("Magic"));
    }
    @Test
    @Order(4)
    public void test_updateAddon() throws Exception {

        String content;
        try{
            content=objectWriter.writeValueAsString(addonDto1);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        MockHttpServletRequestBuilder mockRequest=MockMvcRequestBuilders
                .put("/admin/editAddon/1")
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
    public void test_deleteAddon() throws Exception {
        MockHttpServletRequestBuilder mockRequest=MockMvcRequestBuilders
                .delete("/admin/deleteAddon/1")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);
        mockMvc.perform(mockRequest)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
