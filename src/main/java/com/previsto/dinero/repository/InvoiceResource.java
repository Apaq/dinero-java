package com.previsto.dinero.repository;

import com.previsto.dinero.model.Invoice;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import org.springframework.web.client.RestTemplate;

public class InvoiceResource extends Resource<Invoice>{
    
    public InvoiceResource(RestTemplate restTemplate, String serviceUrl) {
        super(Invoice.class, "invoices", restTemplate, serviceUrl);
    }
    
    public void book(String id) {
        URI url = buildUri(id);
        
        restTemplate.postForEntity(url, null, Void.class);
    }
    
    public void email(String id) {
        URI url = buildUri(id, "/email");
        
        restTemplate.postForEntity(url, null, Void.class);
    }
    
}