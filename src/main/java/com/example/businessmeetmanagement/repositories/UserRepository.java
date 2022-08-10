package com.example.businessmeetmanagement.repositories;

import com.example.businessmeetmanagement.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    public User findByEmailIdAndPassword(String email,String password);
    public User findByEmailId(String email);

}
