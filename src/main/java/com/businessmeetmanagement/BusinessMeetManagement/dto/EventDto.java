package com.businessmeetmanagement.BusinessMeetManagement.dto;

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

    //Getters and Setters

    /*public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public String getApplicantAddress() {
        return applicantAddress;
    }

    public void setApplicantAddress(String applicantAddress) {
        this.applicantAddress = applicantAddress;
    }

    public String getApplicantMobile() {
        return applicantMobile;
    }

    public void setApplicantMobile(String applicantMobile) {
        this.applicantMobile = applicantMobile;
    }

    public String getApplicantEmail() {
        return applicantEmail;
    }

    public void setApplicantEmail(String applicantEmail) {
        this.applicantEmail = applicantEmail;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventTime() {
        return eventTime;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

    public Integer getNoOfPeople() {
        return noOfPeople;
    }

    public void setNoOfPeople(Integer noOfPeople) {
        this.noOfPeople = noOfPeople;
    }

    public Integer getQuantityOfVeg() {
        return quantityOfVeg;
    }

    public void setQuantityOfVeg(Integer quantityOfVeg) {
        this.quantityOfVeg = quantityOfVeg;
    }

    public Integer getQuantityOfNonVeg() {
        return quantityOfNonVeg;
    }

    public void setQuantityOfNonVeg(Integer quantityOfNonVeg) {
        this.quantityOfNonVeg = quantityOfNonVeg;
    }

    public String getSelectFoodCategory() {
        return selectFoodCategory;
    }

    public void setSelectFoodCategory(String selectFoodCategory) {
        this.selectFoodCategory = selectFoodCategory;
    }

    public String getSelectAddOnsCategory() {
        return selectAddOnsCategory;
    }

    public void setSelectAddOnsCategory(String selectAddOnsCategory) {
        this.selectAddOnsCategory = selectAddOnsCategory;
    }
    public EventDto(){
        super();
    }*/
}
