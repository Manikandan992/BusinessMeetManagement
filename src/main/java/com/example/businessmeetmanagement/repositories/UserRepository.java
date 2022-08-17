package com.example.businessmeetmanagement.repositories;

import com.example.businessmeetmanagement.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long>
{

    User findByPhone(String currPhone) ;


    User findByEmail(String email);


    User findByEmailAndPassword(String currEmail, String currPassword);


}
