package com.example.businessmeetmanagement.mapper;

import com.example.businessmeetmanagement.dto.InvoiceDto;
import com.example.businessmeetmanagement.entities.Invoice;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import java.util.Arrays;
import java.util.List;

public class InvoiceMapper {
    public Invoice toInvoice(InvoiceDto invoiceDto){
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return mapper.map(invoiceDto, Invoice.class);
    }

    public InvoiceDto toInvoiceDto(Invoice invoice){
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return mapper.map(invoice, InvoiceDto.class);
    }

    public List<InvoiceDto> toInvoiceDtos(List<Invoice> invoices){
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return Arrays.asList(mapper.map(invoices, InvoiceDto[].class));
    }
}
