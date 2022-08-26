package com.example.businessmeetmanagement.controllers;


import com.example.businessmeetmanagement.dto.UserDto;
import com.example.businessmeetmanagement.entities.AuthenticationRequest;
import com.example.businessmeetmanagement.entities.AuthenticationResponse;
import com.example.businessmeetmanagement.entities.User;
import com.example.businessmeetmanagement.repositories.UserRepository;
import com.example.businessmeetmanagement.security.JwtTokenUtil;
import com.example.businessmeetmanagement.security.MyUserDetailsService;
import com.example.businessmeetmanagement.services.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;


@RestController
@CrossOrigin(origins="http://localhost:4200")
public class AuthController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private MyUserDetailsService userDetailsService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private UserService service;

    @PostConstruct
    public void saveAdmin(){
        service.saveAdmin();
    }
    //register
    @PostMapping("/signup")
    public ResponseEntity<UserDto> register(@RequestBody UserDto user) throws Exception {
        try {
            UserDto userObj = null;
            userObj = service.saveUser(user);
            return new ResponseEntity<>(userObj, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    //login
    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        UserDto userObj = null;
        userObj = service.findByEmail(authenticationRequest.getEmail());
        if (userObj != null) {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            boolean passwordExist = passwordEncoder.matches(authenticationRequest.getPassword(), userObj.getPassword());
            if (passwordExist) {
                final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getEmail());
                final String jwt = jwtTokenUtil.generateToken(userDetails);
                return ResponseEntity.ok(new AuthenticationResponse(jwt, service.findByEmail(authenticationRequest.getEmail())));
            } else {
                return new ResponseEntity<>("password Mismatched", HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<>("Not found", HttpStatus.OK);
        }
    }

    @GetMapping("admin/users")
    public ResponseEntity<List<UserDto>> getAllUsers(){
        List<UserDto> users=service.getAllUsers();
        return new ResponseEntity<>(users,HttpStatus.OK);
    }

    @DeleteMapping("admin/deleteUser/{id}")
    public void deleteUser(@PathVariable("id") Long id){
        service.deleteUser(id);
    }

    @GetMapping("user/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable("id") long id){
        return ResponseEntity.ok(service.getById(id));
    }
}