package com.example.businessmeetmanagement.services;

import com.example.businessmeetmanagement.dto.InvoiceDto;
import com.example.businessmeetmanagement.entities.Invoice;

import java.util.List;

public interface InvoiceService {
    InvoiceDto getInvoice(int uThemeId);
    List<InvoiceDto> getInvoice();
    InvoiceDto addInvoice(InvoiceDto bill);
}
