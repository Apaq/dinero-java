package com.previsto.dinero.repository;

import com.previsto.dinero.model.Contact;
import java.util.HashMap;
import java.util.Map;
import org.springframework.web.client.RestTemplate;

public class ContactResource extends Resource<Contact>{
    
    public ContactResource(RestTemplate restTemplate, String serviceUrl) {
        super(Contact.class, "contacts", restTemplate, serviceUrl);
    }
    
}
