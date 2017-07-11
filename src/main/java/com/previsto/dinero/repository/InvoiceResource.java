package com.previsto.dinero.repository;

import com.previsto.dinero.model.BookData;
import com.previsto.dinero.model.Invoice;

import java.net.URI;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.HashMap;
import java.util.Map;

import com.previsto.dinero.model.PaymentData;
import org.springframework.web.client.RestTemplate;

public class InvoiceResource extends Resource<Invoice>{

    private static final String FIELDS = "Number,Guid,ContactName,Date,PaymentDate,Description,Currency,Status,MailOutStatus,TotalExclVatInDkk,TotalInclVatInDkk,TotalExclVat,TotalInclVat,CreatedAt,UpdatedAt,DeletedAt";

    public InvoiceResource(RestTemplate restTemplate, String serviceUrl) {
        super(Invoice.class, "invoices", restTemplate, serviceUrl, FIELDS);
    }
    
    public void book(Invoice invoice) {
        URI url = buildUri(invoice.getId(), "/book");

        BookData bookData = new BookData();
        bookData.setTimestamp(invoice.getTimestamp());
        
        restTemplate.postForEntity(url, bookData, Void.class);
    }
    
    public void email(String id) {
        URI url = buildUri(id, "/email");
        
        restTemplate.postForEntity(url, null, Void.class);
    }

    public void pay(Invoice invoice, int depositAccountNumber, LocalDate paymentDate, long amount, String description, String externalReference) {
        URI url = buildUri(invoice.getId(), "/payments");
        PaymentData data = new PaymentData();
        data.setTimestamp(invoice.getTimestamp());
        data.setAmount(((double)amount) / 100);
        data.setDepositAccountNumber(depositAccountNumber);
        data.setDescription(description);
        data.setExternalReference(externalReference);
        data.setPaymentDate(paymentDate);

        restTemplate.postForEntity(url, data, Void.class);
    }
    
}