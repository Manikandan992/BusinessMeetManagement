package com.example.businessmeetmanagement.controllers;

import com.example.businessmeetmanagement.dto.InvoiceDto;
import com.example.businessmeetmanagement.services.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class InvoiceController {
    @Autowired
    private InvoiceService invoiceService;

    @PostMapping("/addInvoice")
    public ResponseEntity<InvoiceDto> addInvoice(@RequestBody InvoiceDto invoice){
        return ResponseEntity.ok(invoiceService.addInvoice(invoice));
    }

    @GetMapping("/getInvoice/{invoiceId}")
    public ResponseEntity<InvoiceDto> getInvoice(@PathVariable("invoiceId") Integer invoiceId){
        return ResponseEntity.ok(invoiceService.getInvoice(invoiceId));
    }


}
