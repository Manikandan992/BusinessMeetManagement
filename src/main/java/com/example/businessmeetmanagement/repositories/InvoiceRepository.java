package com.example.businessmeetmanagement.repositories;

import com.example.businessmeetmanagement.entities.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice,Integer> {
}