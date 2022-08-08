package com.example.businessmeetmanagement.dto;

import lombok.Data;

@Data
public class EventDto {
    private Integer eventId;
    private Integer userId;
    private String eventName;
    private String applicantName;
    private String applicantAddress;
    private String applicantMobile;
    private String applicantEmail;
    private String eventDate;
    private String eventTime;
    private Integer noOfPeople;
    private Integer quantityOfVeg;
    private Integer quantityOfNonVeg;
    private String selectFoodCategory;
    private String selectAddOnsCategory;
}
