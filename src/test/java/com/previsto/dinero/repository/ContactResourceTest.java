package com.previsto.dinero.repository;

import com.previsto.dinero.model.Contact;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
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
        return "?include=contact.city,contact.zipcode,contact.contactPersons:embed";
    }

    @Override
    protected String generateSingularId() {
        return "DDAc0RmLQyelyZrv55JJKg";
    }
    
    @Override
    protected List<RequestMatcher> generateExpectedSaveRequest() {
        List<RequestMatcher> matchers = new ArrayList<>();
        matchers.add(jsonPath("$.contact.isArchived").value(false));
        matchers.add(jsonPath("$.contact.name").isEmpty());
        matchers.add(jsonPath("$.contact.paymentTermsDays").doesNotExist());
        matchers.add(jsonPath("$.contact.paymentTermsMode").doesNotExist());
        return matchers;
    }

    @Override
    protected void doCheckEntity(Contact entity) {
        if ("EkoYx6TBSPC7rixfDCaM1Q".equals(entity.getId())) {
            assertEquals(false, entity.isArchived());
            assertEquals(LocalDateTime.parse("2016-12-23T08:06:07"), entity.getCreatedTime());
            return;
        }

        if ("DDAc0RmLQyelyZrv55JJKg".equals(entity.getId())) {
            assertEquals(false, entity.isArchived());
            assertEquals(LocalDateTime.parse("2016-12-23T08:06:40"), entity.getCreatedTime());
            return;
        }

        throw new RuntimeException("Unexpected contact entity [id=" + entity.getId() + "]");
    }

}
