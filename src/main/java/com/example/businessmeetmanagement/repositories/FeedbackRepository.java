package com.example.businessmeetmanagement.repositories;

import com.example.businessmeetmanagement.entities.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<Feedback,Long > {

}
