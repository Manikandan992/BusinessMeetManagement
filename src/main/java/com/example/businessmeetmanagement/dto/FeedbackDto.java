package com.example.businessmeetmanagement.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FeedbackDto
{
    private long id;
    private String name;
    private String feedbackMsg;
}