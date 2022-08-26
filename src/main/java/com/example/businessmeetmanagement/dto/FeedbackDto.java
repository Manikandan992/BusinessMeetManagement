package com.example.businessmeetmanagement.dto;

import lombok.*;

@Data
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class FeedbackDto
{
    private long id;
    private String name;
    private String feedbackMsg;
}