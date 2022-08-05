package com.example.businessmeetmanagement.repositories;

import com.example.businessmeetmanagement.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findByUsername(String username);
    User findByEmailId(String emailId);
}
