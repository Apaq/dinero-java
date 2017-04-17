package com.previsto.dinero.repository;

import com.previsto.dinero.model.Invoice;
import com.previsto.dinero.model.enums.InvoiceState;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
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
        return "?include=invoice.lines:embed";
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
            assertEquals(LocalDateTime.parse("2016-12-23T08:18:20"), entity.getCreatedTime());
            assertEquals(InvoiceState.Approved, entity.getState());
            return;
        }

        if ("cSHBqWWITexZvQy29lqpYg".equals(entity.getId())) {
            assertEquals(LocalDateTime.parse("2016-12-23T08:16:46"), entity.getCreatedTime());
            assertEquals(InvoiceState.Draft, entity.getState());
            return;
        }

        if ("o9bpexuzTb25IfEgW7E1Wg".equals(entity.getId())) {
            assertEquals(LocalDateTime.parse("2016-12-23T08:13:48"), entity.getCreatedTime());
            assertEquals(InvoiceState.Approved, entity.getState());
            return;
        }
        throw new RuntimeException("Unexpected contact entity [id=" + entity.getId() + "]");
    }

}
