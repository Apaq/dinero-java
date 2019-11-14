package com.previsto.dinero.repository;

import com.previsto.dinero.model.*;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
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

    public SendEmailResponse email(String id) {
        return this.email(id, new SendEmailRequest());
    }

    public SendEmailResponse email(String id, SendEmailRequest sendEmailRequest) {
        URI url = buildUri(id, "/email");
        
        ResponseEntity<SendEmailResponse> response = restTemplate.postForEntity(url, sendEmailRequest, SendEmailResponse.class);
        return response.getBody();
    }

    public InputStream download(String id) throws IOException {
        URI url = buildUri(id);

        RequestEntity req = RequestEntity.get(url).accept(MediaType.APPLICATION_OCTET_STREAM).build();
        ResponseEntity<org.springframework.core.io.Resource> res = restTemplate.exchange(req, org.springframework.core.io.Resource.class );
        return res.getBody().getInputStream();
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