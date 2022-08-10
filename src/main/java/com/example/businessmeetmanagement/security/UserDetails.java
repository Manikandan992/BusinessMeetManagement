package com.example.businessmeetmanagement.security;

import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;
import java.util.Collection;

public interface UserDetails extends Serializable {
    Collection<? extends GrantedAuthority> getAuthorities();

    String getPassword();

    String getEmail();

    boolean isAccountNonExpired();


    boolean isAccountNonLocked();


    boolean isCredentialsNonExpired();

    boolean isEnabled();

}