package com.example.businessmeetmanagement.services.impl;

import com.example.businessmeetmanagement.entities.Role;
import com.example.businessmeetmanagement.entities.User;
import com.example.businessmeetmanagement.exceptions.ResourceNotFoundException;
import com.example.businessmeetmanagement.model.UserRequest;
import com.example.businessmeetmanagement.repositories.UserRepository;
import com.example.businessmeetmanagement.services.UserAuthenticationServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional

public class UserAuthenticationServicesImpl implements UserAuthenticationServices, UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String username) {
        User user= userRepository.findByUsername(username).orElseThrow(()->new ResourceNotFoundException("User not found with the username "+username));
        List<Role> roles = user.getRoles().stream().collect(Collectors.toList());
        List<GrantedAuthority> grantedAuthorities = roles.stream().map(role ->
            new SimpleGrantedAuthority(role.getRoleName())
        ).collect(Collectors.toList());
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(username,user.getPassword(),grantedAuthorities);
        log.info("User with"+username+"is present");
        return userDetails;
    }


    @Override
    public void registerUser(UserRequest userRequest) {
        Optional<User> user = userRepository.findByUsername(userRequest.getUsername());
        if(user.isPresent()) {
            log.error("User with "+userRequest.getUsername()+"Already Exist by Trying to Signup again");
            throw new ResourceNotFoundException("User Already Exist");
        }
        User userTemp = new User();
        userTemp.setName(userRequest.getName());
        userTemp.setEmailId(userRequest.getEmailId());
        userTemp.setPhoneNumber(userRequest.getPhoneNumber());
        userTemp.setUsername(userRequest.getUsername());
        userTemp.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        userTemp.setRoles(userRequest.getRoles().stream().map(role->{
            Role roleTemp = new Role();
            roleTemp.setRoleName(role);
            roleTemp.setUser(userTemp);
            return roleTemp;
        }).collect(Collectors.toSet()));
        log.info("User "+ userRequest.getUsername()+"Registration is in progress");
        userRepository.save(userTemp);
        log.info(userTemp.getUsername()+" Registered Successfully");
    }
    @Override
    public User getUserById(int userId){
        return userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User Not Found"));
    }
    @Override
    public User getUserByUserName(String userName){
        return userRepository.findByUsername(userName).orElseThrow(()->new ResourceNotFoundException("User Not Found"));
    }
}