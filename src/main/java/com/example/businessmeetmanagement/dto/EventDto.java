package com.example.businessmeetmanagement.dto;

import com.example.businessmeetmanagement.entities.User;
import lombok.Data;

@Data
public class EventDto {

    private Integer eventId;
    private String emailId;
    private String eventName;
    private String applicantName;
    private String applicantAddress;
    private String applicantMobile;
    private String applicantEmail;
    private String location;
    private String eventDate;
    private String eventTime;
    private Integer noOfPeople;
    private String selectItem;
    private Integer quantity;
    private String selectAddOnsCategory;
    private long userId;
}