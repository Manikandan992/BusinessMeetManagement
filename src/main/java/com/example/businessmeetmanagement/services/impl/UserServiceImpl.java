package com.example.businessmeetmanagement.services.impl;

import com.example.businessmeetmanagement.dto.UserDto;
import com.example.businessmeetmanagement.entities.User;
import com.example.businessmeetmanagement.exceptions.ResourceNotFoundException;
import com.example.businessmeetmanagement.mapper.UserMapper;
import com.example.businessmeetmanagement.repositories.UserRepository;
import com.example.businessmeetmanagement.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    public PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository repository;
    @Autowired
    private UserMapper mapper;
    //Register
    public UserDto saveUser(UserDto user1) throws ResourceNotFoundException
    {
        User user=mapper.toUser(user1);
        String currentMail=user.getEmail();
        String currPhone=user.getPhone();
        User userObj = repository.findByEmail(currentMail);
        User userPhn=repository.findByPhone(currPhone);

        if(userObj != null && userPhn !=null)
        {
            throw new ResourceNotFoundException("Email and phone number already exists !!!");
        }
        if(userObj != null)
        {
            throw new ResourceNotFoundException("Email id already exists !!!");
        }
        if(userPhn != null)
        {
            throw new ResourceNotFoundException("Phone number already exists !!!");
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        user=repository.save(user);
        log.info("New user Added");
        return mapper.toUserDto(user);
    }

    //Login
    public User fetchByEmail(User user) throws ResourceNotFoundException
    {
        String currEmail=user.getEmail();
        String currPassword=user.getPassword();
        return repository.findByEmailAndPassword(currEmail,currPassword);
    }


    public UserDto findByEmail(String email) {
        User user = repository.findByEmail(email);
        return mapper.toUserDto(user);
    }


    public UserDto getById(Long id) {
        return mapper.toUserDto(repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User Not Found")));
    }

    @Override
    public List<UserDto> getAllUsers() {
        return mapper.toUserDtos(repository.findAll());
    }

    @Override
    public void saveAdmin() {
        if (repository.findByEmail("admin@gmail.com")==null) {
            User adminUser = new User();
            adminUser.setName("admin");
            adminUser.setUsertype("admin");
            adminUser.setEmail("admin@gmail.com");
            adminUser.setPhone("0000000000");
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            adminUser.setPassword(encoder.encode("admin@123"));
            repository.save(adminUser);
        }
    }

    @Override
    public void deleteUser(Long id) {
        repository.deleteById(id);
        log.warn("user with id:"+id+" deleted");
    }
}