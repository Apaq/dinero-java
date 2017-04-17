package com.previsto.billy.repository;

import com.previsto.billy.mapping.PersistContactMapping;
import com.previsto.billy.mapping.PluralContactMapping;
import com.previsto.billy.mapping.SingularContactMapping;
import com.previsto.billy.model.Contact;
import java.util.HashMap;
import java.util.Map;
import org.springframework.web.client.RestTemplate;

public class ContactResource extends Resource<Contact>{
    
    private static final Map<String, String> SIDELOAD_PARAMS = new HashMap<>();
    
    static {
        SIDELOAD_PARAMS.put("include", "contact.city,contact.zipcode,contact.contactPersons:embed");
    }
    
    public ContactResource(RestTemplate restTemplate, String serviceUrl) {
        super(SingularContactMapping.class, PluralContactMapping.class, PersistContactMapping.class, "contacts", restTemplate, serviceUrl, SIDELOAD_PARAMS);
    }
    
}
