package com.example.businessmeetmanagement.security;

import com.example.businessmeetmanagement.entities.User;
import com.example.businessmeetmanagement.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MyUserDetailService  implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String emailId) throws UsernameNotFoundException {
        User user = userRepository.findByEmailId(emailId);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + emailId);
        }
        return new org.springframework.security.core.userdetails.User(user.getEmailId(), user.getPassword(),
                new ArrayList<>());

    }
}