package com.example.businessmeetmanagement.dto;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor

public class EventDto {

    private int eventId;
    private String eventName;
    private String name;
    private String userAddress;
    private String eventDate;
    private String phoneNumber;
    private String email;
    private String eventTime;
    private int noOfPeople;
    private int menu;
    private int addon;
    private int theme;
    private long userId;
}