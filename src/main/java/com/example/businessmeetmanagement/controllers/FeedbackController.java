package com.example.businessmeetmanagement.controllers;

import com.example.businessmeetmanagement.dto.FeedbackDto;
import com.example.businessmeetmanagement.services.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @PostMapping("user/add-feedback")
    public ResponseEntity<FeedbackDto> addFeedback(@RequestBody FeedbackDto feedback){
        return ResponseEntity.ok(feedbackService.addFeedback(feedback));
    }

    @GetMapping(value = {"user/feedback","admin/feedback"})
    public ResponseEntity<List<FeedbackDto>> getAllFeedbacks(){
        List<FeedbackDto> feedbacks = feedbackService.getFeedbacks();
        return new ResponseEntity<>(feedbacks, HttpStatus.OK);
    }
}
