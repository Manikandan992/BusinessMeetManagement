package com.example.businessmeetmanagement.services.impl;

import com.example.businessmeetmanagement.dto.FeedbackDto;
import com.example.businessmeetmanagement.entities.Feedback;
import com.example.businessmeetmanagement.mapper.FeedbackMapper;
import com.example.businessmeetmanagement.repositories.FeedbackRepository;
import com.example.businessmeetmanagement.services.FeedbackService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@Slf4j
public class FeedbackServiceImpl implements FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    @Autowired
    private FeedbackMapper mapper;

    @Override
    public FeedbackDto addFeedback(FeedbackDto feedback) {
        Feedback feedback1 = mapper.toFeedback(feedback);
        feedback1=feedbackRepository.save(feedback1);
        log.info("New Feedback Added");
        return mapper.toFeedbackDto(feedback1);
    }

    @Override
    public List<FeedbackDto> getFeedbacks() {
        return mapper.toFeedbackDtos(feedbackRepository.findAll());
    }

    @Override
    public void deleteFeedback(long id) {
        feedbackRepository.deleteById(id);
        log.warn("Feedback Deleted");
    }
}
