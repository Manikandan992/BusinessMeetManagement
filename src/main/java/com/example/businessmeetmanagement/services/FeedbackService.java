package com.example.businessmeetmanagement.services;

import com.example.businessmeetmanagement.dto.FeedbackDto;

import java.util.List;

public interface FeedbackService {
    FeedbackDto addFeedback(FeedbackDto feedback);
    List<FeedbackDto> getFeedbacks();
    void deleteFeedback(long id);
}
