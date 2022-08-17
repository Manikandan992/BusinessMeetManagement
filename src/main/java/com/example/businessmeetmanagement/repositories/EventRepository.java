package com.example.businessmeetmanagement.repositories;

import com.example.businessmeetmanagement.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<Event,Integer> {
    List<Event> findAllByUserId(long userId);
}
