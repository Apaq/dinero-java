package dk.apaq.dinero.repository;

import dk.apaq.dinero.model.Contact;

import org.springframework.web.client.RestTemplate;

public class ContactResource extends Resource<Contact>{

    private static final String FIELDS = "ContactGuid,CreatedAt,UpdatedAt,DeletedAt,IsDebitor,IsCreditor,ExternalReference,Name,Street,ZipCode,City,CountryKey,Phone,Email,Webpage,AttPerson,VatNumber,EanNumber,PaymentConditionType,PaymentConditionNumberOfDays,IsPerson";
    
    public ContactResource(RestTemplate restTemplate, String serviceUrl) {
        super(Contact.class, "contacts", restTemplate, serviceUrl, FIELDS);
    }
    
}
