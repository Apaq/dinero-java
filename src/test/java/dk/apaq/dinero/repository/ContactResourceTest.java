package dk.apaq.dinero.repository;

import dk.apaq.dinero.model.Contact;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.response.DefaultResponseCreator;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;
import static org.junit.Assert.*;
import org.springframework.test.web.client.RequestMatcher;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.*;

public class ContactResourceTest extends ResourceTestBase<Contact> {

    public ContactResourceTest() {
        super(new ContactResource(buildRestTemplate(), "http://server/Api"), Contact.class);
    }

    @Override
    protected DefaultResponseCreator generateExpectedGetResponse() {
        return withSuccess(Util.readResourceFromFile("contacts_single.json"), MediaType.APPLICATION_JSON);
    }

    @Override
    protected DefaultResponseCreator generateExpectedFindAllResponse() {
        return withSuccess(Util.readResourceFromFile("contacts_list.json"), MediaType.APPLICATION_JSON);
    }

    @Override
    protected String generateExpectedGetQueryParams() {
        return "?page=0&pageSize=1000&fields=ContactGuid,CreatedAt,UpdatedAt,DeletedAt,IsDebitor,IsCreditor,ExternalReference,Name,Street,ZipCode,City,CountryKey,Phone,Email,Webpage,AttPerson,VatNumber,EanNumber,PaymentConditionType,PaymentConditionNumberOfDays,IsPerson";
    }

    @Override
    protected String generateSingularId() {
        return "716a3105-e8fd-4fdd-a886-0490b047986f";
    }
    
    @Override
    protected List<RequestMatcher> generateExpectedSaveRequest() {
        List<RequestMatcher> matchers = new ArrayList<>();
        matchers.add(method(HttpMethod.PUT));
        //matchers.add(content().string(""));
        matchers.add(jsonPath("$.Creditor").value(false));
        return matchers;
    }

    @Override
    protected void prepareForSave(Contact entity) {
        entity.setCreditor(false);
    }

    @Override
    protected void doCheckEntity(Contact entity) {
        if ("716a3105-e8fd-4fdd-a886-0490b047986f".equals(entity.getId())) {
            assertEquals(LocalDateTime.parse("2017-05-19T14:14:47"), entity.getCreatedAt());
            return;
        }

        if ("345af4c6-0867-4040-8fb9-62625b5ef3c1".equals(entity.getId())) {
            assertEquals(LocalDateTime.parse("2017-05-20T17:15:00"), entity.getCreatedAt());
            return;
        }

        throw new RuntimeException("Unexpected contact entity [id=" + entity.getId() + "]");
    }

}
