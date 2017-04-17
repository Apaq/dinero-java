package com.previsto.billy.repository;

import com.previsto.billy.mapping.PersistInvoiceMapping;
import com.previsto.billy.mapping.PluralInvoiceMapping;
import com.previsto.billy.mapping.SingularInvoiceMapping;
import com.previsto.billy.mapping.SingularMapping;
import com.previsto.billy.model.Email;
import com.previsto.billy.model.Invoice;
import com.previsto.billy.model.enums.InvoiceState;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import org.springframework.web.client.RestTemplate;

public class InvoiceResource extends Resource<Invoice>{
    
    private static final Map<String, String> SIDELOAD_PARAMS = new HashMap<>();
    
    static {
        SIDELOAD_PARAMS.put("include", "invoice.lines:embed");
    }
    
    public InvoiceResource(RestTemplate restTemplate, String serviceUrl) {
        super(SingularInvoiceMapping.class, PluralInvoiceMapping.class, PersistInvoiceMapping.class, "invoices", restTemplate, serviceUrl, SIDELOAD_PARAMS);
    }
    
    public void approve(String id) {
        URI url = buildUri(id);
        
        Map<String, Map> body = new HashMap<>();
        Map<String, InvoiceState> data = new HashMap<>();
        
        body.put("invoice", data);
        data.put("state", InvoiceState.Approved);
        
        
        restTemplate.put(url, body);
    }
    
    public void send(String id, Email email) {
        URI url = buildUri(id, "/emails");
        
        Map<String, Email> body = new HashMap<>();
        body.put("email", email);
        restTemplate.postForEntity(url, body, Map.class);
    }
    
}