package com.previsto.dinero.repository;

import com.previsto.dinero.model.Invoice;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.previsto.dinero.model.InvoiceStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.response.DefaultResponseCreator;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;
import static org.junit.Assert.*;
import org.springframework.test.web.client.RequestMatcher;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.*;

public class InvoiceResourceTest extends ResourceTestBase<Invoice> {

    public InvoiceResourceTest() {
        super(new InvoiceResource(buildRestTemplate(), "http://server/Api"), Invoice.class);
    }

    @Override
    protected DefaultResponseCreator generateExpectedGetResponse() {
        return withSuccess(Util.readResourceFromFile("invoices_single.json"), MediaType.APPLICATION_JSON);
    }

    @Override
    protected DefaultResponseCreator generateExpectedFindAllResponse() {
        return withSuccess(Util.readResourceFromFile("invoices_list.json"), MediaType.APPLICATION_JSON);
    }

    @Override
    protected String generateExpectedGetQueryParams() {
        return "";
    }

    @Override
    protected String generateSingularId() {
        return "cSHBqWWITexZvQy29lqpYg";
    }
    
    @Override
    protected List<RequestMatcher> generateExpectedSaveRequest() {
        List<RequestMatcher> matchers = new ArrayList<>();
        matchers.add(jsonPath("$.invoice.isPaid").doesNotExist());
        matchers.add(jsonPath("$.invoice.paymentTermsDays").doesNotExist());
        matchers.add(jsonPath("$.invoice.paymentTermsMode").doesNotExist());
        return matchers;
    }

    @Override
    protected void doCheckEntity(Invoice entity) {
        if ("UdsHDvAESV2eCZHSCYOfzA".equals(entity.getId())) {
            assertEquals(LocalDateTime.parse("2016-12-23T08:18:20"), entity.getCreatedAt());
            assertEquals(InvoiceStatus.Booked, entity.getInvoiceStatus());
            return;
        }

        if ("cSHBqWWITexZvQy29lqpYg".equals(entity.getId())) {
            assertEquals(LocalDateTime.parse("2016-12-23T08:16:46"), entity.getCreatedAt());
            assertEquals(InvoiceStatus.Draft, entity.getInvoiceStatus());
            return;
        }

        if ("o9bpexuzTb25IfEgW7E1Wg".equals(entity.getId())) {
            assertEquals(LocalDateTime.parse("2016-12-23T08:13:48"), entity.getCreatedAt());
            assertEquals(InvoiceStatus.Booked, entity.getInvoiceStatus());
            return;
        }
        throw new RuntimeException("Unexpected contact entity [id=" + entity.getId() + "]");
    }

}
