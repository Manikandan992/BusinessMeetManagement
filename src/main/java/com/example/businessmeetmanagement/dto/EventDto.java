package com.example.businessmeetmanagement.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class EventDto {

    private int eventId;
    private String eventName;
    private String name;
    private String userAddress;
    private LocalDate eventDate;
    private String phoneNumber;
    private String email;
    private LocalTime eventTime;
    private int noOfPeople;
    private int menu;
    private int addon;
    private int theme;
    private long userId;
}