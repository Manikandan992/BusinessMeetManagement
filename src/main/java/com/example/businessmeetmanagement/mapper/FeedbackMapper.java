package com.example.businessmeetmanagement.mapper;

import com.example.businessmeetmanagement.dto.FeedbackDto;
import com.example.businessmeetmanagement.dto.ThemeDto;
import com.example.businessmeetmanagement.entities.Feedback;
import com.example.businessmeetmanagement.entities.Theme;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class FeedbackMapper {
    public Feedback toFeedback(FeedbackDto feedbackDto){
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return mapper.map(feedbackDto,Feedback.class);
    }
//    public Theme toTheme(ThemeDto themeDto){
//        ModelMapper mapper = new ModelMapper();
//        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
//        return mapper.map(themeDto,Theme.class);
//    }

    public FeedbackDto toFeedbackDto(Feedback feedback){
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return mapper.map(feedback,FeedbackDto.class);
    }
//    public ThemeDto toThemeDto(Theme theme){
//        ModelMapper mapper = new ModelMapper();
//        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
//        return mapper.map(theme,ThemeDto.class);
//    }

    public List<FeedbackDto> toFeedbackDtos(List<Feedback> feedbacks){
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return Arrays.asList(mapper.map(feedbacks,FeedbackDto[].class));
    }
}
