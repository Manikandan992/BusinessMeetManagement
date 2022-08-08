package com.example.businessmeetmanagement.controllers;

import com.example.businessmeetmanagement.Util.JwtUtil;
import com.example.businessmeetmanagement.model.SuccessResponse;
import com.example.businessmeetmanagement.model.UserRequest;
import com.example.businessmeetmanagement.model.UserRequestSignin;
import com.example.businessmeetmanagement.model.UserResponse;
import com.example.businessmeetmanagement.services.UserAuthenticationServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/")
@SuppressWarnings("rawtypes")
@Slf4j
public class UserController {

    @Autowired
    private UserAuthenticationServices userAuthenticationServices;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<UserResponse> signIn(@RequestBody UserRequestSignin userRequestSignin){
        Authentication authentication = null;
        try{
            authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userRequestSignin.getUsername(),userRequestSignin.getPassword()));
        }
        catch(BadCredentialsException e){
            log.error("User"+userRequestSignin.getUsername()+"Has entered Invalid Password");
            throw new BadCredentialsException("Invalid Credentials");
        }
        String token = jwtUtil.generateToken(authentication);
        User user = (User)authentication.getPrincipal();
        List<String> roles = user.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());
        UserResponse userResponse= new UserResponse();
        userResponse.setToken(token);
        userResponse.setRoles(roles);
        userResponse.setUserId(userAuthenticationServices.getUserByUserName(user.getUsername()).getUserId());
        log.info("User"+user.getUsername()+"authenticated Successfullu]y");
        return ResponseEntity.ok(userResponse);
    }

    @PostMapping("/signup")
    public ResponseEntity<SuccessResponse> signUp(@RequestBody UserRequest userRequest){
        userAuthenticationServices.registerUser(userRequest);
        log.info(userRequest.getUsername()+" "+"registered Successfully");
        SuccessResponse successResponse = new SuccessResponse();
        successResponse.setSuccessMessage("User Registered Successfully");
        return new ResponseEntity<>(successResponse, HttpStatus.CREATED);
    }
}
