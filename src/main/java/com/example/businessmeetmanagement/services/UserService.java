package com.example.businessmeetmanagement.services;

import com.example.businessmeetmanagement.dto.UserDto;
import com.example.businessmeetmanagement.entities.User;
import com.example.businessmeetmanagement.exceptions.ResourceNotFoundException;

import java.util.List;

public interface UserService {
    public UserDto saveUser(UserDto user) throws ResourceNotFoundException;
    public User fetchByEmail(User user) throws ResourceNotFoundException;
    public UserDto findByEmail(String email);
    public UserDto getById(Long id);
    List<UserDto> getAllUsers();
    void saveAdmin();
    void deleteUser(Long id);
}
