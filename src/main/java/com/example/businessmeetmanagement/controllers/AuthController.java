package com.example.businessmeetmanagement.controllers;

import com.example.businessmeetmanagement.entities.AuthenticationRequest;
import com.example.businessmeetmanagement.entities.AuthenticationResponse;
import com.example.businessmeetmanagement.entities.User;
import com.example.businessmeetmanagement.repositories.UserRepository;
import com.example.businessmeetmanagement.security.JwtTokenUtil;
import com.example.businessmeetmanagement.security.MyUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@CrossOrigin("*")
public class AuthController {

    @Autowired
    private MyUserDetailService userDetailService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserRepository urepo;

    @PostMapping("/signup")
    public ResponseEntity<String> saveUser(@RequestBody User user) {
        User user1=urepo.findByEmailId(user.getEmailId());
        if(user1!=null)
        {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Already Exist");

        }
        else
        {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String encodedPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(encodedPassword);
            urepo.save(user);
            return ResponseEntity.ok("User added");
        }


    }
    @PostMapping("/login")
    public  ResponseEntity<?> login(@RequestBody AuthenticationRequest authenticationRequest)throws Exception {
        User userObj = null;
        userObj = urepo.findByEmailId(authenticationRequest.getEmailId());
        if (userObj != null) {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            boolean passwordExist = passwordEncoder.matches(authenticationRequest.getPassword(), userObj.getPassword());
            if (passwordExist) {
                final org.springframework.security.core.userdetails.UserDetails userDetails = userDetailService.loadUserByUsername(authenticationRequest.getEmailId());
                final String jwt = jwtTokenUtil.generateToken(userDetails);
                return ResponseEntity.ok(new AuthenticationResponse(jwt, urepo.findByEmailId(authenticationRequest.getEmailId())));
            } else {
                return new ResponseEntity<>("password Mismatched", HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<>("Not found", HttpStatus.OK);
        }
    }
}
