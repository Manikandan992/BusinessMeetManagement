package com.example.businessmeetmanagement.mapper;

import com.example.businessmeetmanagement.dto.UserDto;
import com.example.businessmeetmanagement.entities.User;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class UserMapper {
    public User toUser(UserDto userDto){
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return mapper.map(userDto,User.class);
    }

    public UserDto toUserDto(User user){
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return mapper.map(user,UserDto.class);
    }

    public List<UserDto> toUserDtos(List<User> users){
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return Arrays.asList(mapper.map(users,UserDto[].class));
    }
}
