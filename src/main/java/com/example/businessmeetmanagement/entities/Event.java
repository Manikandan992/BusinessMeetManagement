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
<<<<<<< HEAD
    private String eventDate;
    private String phoneNumber;
    private String email;
    private String eventTime;
=======
    private String  eventDate;
    private String phoneNumber;
    private String email;
    private String  eventTime;
>>>>>>> 409e0a4c7cf53db93d65201555c3322b47fdabc0
    private int noOfPeople;
    private int menu;
    private int addon;
    private int theme;
    private long userId;
}
