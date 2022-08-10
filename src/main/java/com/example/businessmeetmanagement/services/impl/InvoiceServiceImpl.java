package com.example.businessmeetmanagement.services.impl;
import com.example.businessmeetmanagement.dto.InvoiceDto;
import com.example.businessmeetmanagement.entities.Invoice;
import com.example.businessmeetmanagement.exceptions.ResourceNotFoundException;

import com.example.businessmeetmanagement.mapper.InvoiceMapper;
import com.example.businessmeetmanagement.repositories.InvoiceRepository;
import com.example.businessmeetmanagement.services.InvoiceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
@Slf4j
public class InvoiceServiceImpl implements InvoiceService {
    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private InvoiceMapper mapper;

    @Override
    public InvoiceDto getInvoice(int uThemeId) {
        return mapper.toInvoiceDto(invoiceRepository.findById(uThemeId)
                .orElseThrow(()->new ResourceNotFoundException("Addon not found")));
    }

    @Override
    public List<InvoiceDto> getInvoice() {
        return mapper.toInvoiceDtos(invoiceRepository.findAll());
    }

    @Override
    public InvoiceDto addInvoice(InvoiceDto invoice) {
        Invoice invoice1 = mapper.toInvoice(invoice);
        invoice1 = invoiceRepository.save(invoice1);
        log.info("New Invoice Added");
        return mapper.toInvoiceDto(invoice1);
    }
}

