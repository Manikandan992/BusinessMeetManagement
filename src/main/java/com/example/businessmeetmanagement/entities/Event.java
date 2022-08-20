package com.example.businessmeetmanagement.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor

public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private long userId;
}
