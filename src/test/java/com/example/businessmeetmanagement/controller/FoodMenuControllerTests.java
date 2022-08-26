package com.example.businessmeetmanagement.controller;

import com.example.businessmeetmanagement.controllers.FoodMenuController;
import com.example.businessmeetmanagement.dto.FoodMenuDto;
import com.example.businessmeetmanagement.services.FoodMenuService;
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
public class FoodMenuControllerTests {
    @InjectMocks
    FoodMenuController foodMenuController;
    @Mock
    FoodMenuService foodMenuService;
    ObjectMapper objectMapper=new ObjectMapper();
    ObjectWriter objectWriter=objectMapper.writer();
    private MockMvc mockMvc;
    FoodMenuDto foodMenuDto1=new FoodMenuDto(1,"Pizza","12-8-90",80,"Non-veg");
    FoodMenuDto foodMenuDto2=new FoodMenuDto(2,"Burger","12-08-2020",90,"veg");
    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        this.mockMvc= MockMvcBuilders.standaloneSetup(foodMenuController).build();
    }
    @Test
    @Order(1)
    public void test_addFoodMenu(){
        String content;
        FoodMenuDto output=foodMenuDto1;
        try{
            content=objectWriter.writeValueAsString(foodMenuDto1);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        MockHttpServletRequestBuilder mockRequest= MockMvcRequestBuilders
                .post("/admin/addFoodMenu/")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("utf-8")
                .content(content);
        try{
            mockMvc.perform(mockRequest)
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andDo(MockMvcResultHandlers.print());
            Assert.assertEquals(foodMenuDto1,output);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    @Order(2)
    public void test_getFoodMenus() throws Exception {
        List<FoodMenuDto> foodList=new ArrayList<>(Arrays.asList(foodMenuDto1,foodMenuDto2));
        Mockito.when(foodMenuService.getFoodMenus()).thenReturn(foodList);
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/admin/foodMenus")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$",hasSize(2)))
                .andDo(MockMvcResultHandlers.print());
    }
    @Test
    @Order(3)
    public void test_getFoodMenu() throws Exception {
        int id=1;
        Mockito.when(foodMenuService.getFoodMenu(id)).thenReturn(foodMenuDto1);
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/admin/foodMenu/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.menuName").value("Pizza"));
    }
    @Test
    @Order(4)
    public void test_updateFoodMenu() throws Exception {
        int id=1;
        String content;
        try{
            content=objectWriter.writeValueAsString(foodMenuDto1);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        MockHttpServletRequestBuilder mockRequest=MockMvcRequestBuilders
                .put("/admin/editFoodMenu/1")
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
    public void test_deleteFoodMenu() throws Exception {
        int id=1;
        MockHttpServletRequestBuilder mockRequest=MockMvcRequestBuilders
                .delete("/admin/deleteFoodMenu/1")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);
        mockMvc.perform(mockRequest)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
