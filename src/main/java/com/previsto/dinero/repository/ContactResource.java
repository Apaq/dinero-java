package com.previsto.dinero.repository;

import com.previsto.dinero.model.Contact;
import java.util.HashMap;
import java.util.Map;
import org.springframework.web.client.RestTemplate;

public class ContactResource extends Resource<Contact>{

    private static final String FIELDS = "ContactGuid,CreatedAt,UpdatedAt,DeletedAt,IsDebitor,IsCreditor,ExternalReference,Name,Street,ZipCode,City,CountryKey,Phone,Email,Webpage,AttPerson,VatNumber,EanNumber,PaymentConditionType,PaymentConditionNumberOfDays,IsPerson";
    
    public ContactResource(RestTemplate restTemplate, String serviceUrl) {
        super(Contact.class, "contacts", restTemplate, serviceUrl, FIELDS);
    }
    
}
