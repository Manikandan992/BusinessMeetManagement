package com.example.businessmeetmanagement.filter;

import com.example.businessmeetmanagement.Util.JwtUtil;
import com.example.businessmeetmanagement.exceptions.ResourceNotFoundException;
import com.example.businessmeetmanagement.services.UserAuthenticationServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Slf4j
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserAuthenticationServices userAuthenticationServices;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String header = request.getHeader("Authorization");
        if (header==null || ! header.startsWith("HTTP_TOKEN")){
            log.error("No JWT Token Found in the Request sent by the user");
            throw new ResourceNotFoundException("No JWT token Found in the Request");
        }
        String token = header.substring("HTTP_TOKEN".length()+1);
        jwtUtil.validateToken(token);
        String username = jwtUtil.getUsername(token);
        UserDetails userDetails = userAuthenticationServices.loadUserByUsername(username);
        UsernamePasswordAuthenticationToken authentication =
                new UsernamePasswordAuthenticationToken(
                userDetails,null,userDetails.getAuthorities());
        if (SecurityContextHolder.getContext().getAuthentication()==null){
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        filterChain.doFilter(request,response);
    }
}
