package dk.apaq.dinero.repository;

import dk.apaq.dinero.model.Invoice;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import dk.apaq.dinero.model.InvoiceProductLine;
import dk.apaq.dinero.model.InvoiceStatus;
import dk.apaq.dinero.model.SendEmailResponse;
import org.junit.Test;
import org.springframework.http.HttpMethod;
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
        return "?page=0&pageSize=1000&fields=Number,Guid,ContactName,Date,PaymentDate,Description,Currency,Status,MailOutStatus,TotalExclVatInDkk,TotalInclVatInDkk,TotalExclVat,TotalInclVat,CreatedAt,UpdatedAt,DeletedAt";
    }

    @Override
    protected String generateSingularId() {
        return "cSHBqWWITexZvQy29lqpYg";
    }

    @Override
    protected void prepareForSave(Invoice entity) {
        InvoiceProductLine line1 = new InvoiceProductLine();
        line1.setDescription("qwerty");

        InvoiceProductLine line2 = new InvoiceProductLine();
        line2.setProductId("prod_1");
        line2.setDescription("qwerty");

        entity.getProductLines().add(line1);
        entity.getProductLines().add(line2);
    }

    @Override
    protected List<RequestMatcher> generateExpectedSaveRequest() {
        List<RequestMatcher> matchers = new ArrayList<>();
        matchers.add(method(HttpMethod.PUT));
        matchers.add(jsonPath("$.invoice.isPaid").doesNotExist());
        matchers.add(jsonPath("$.invoice.paymentTermsDays").doesNotExist());
        matchers.add(jsonPath("$.invoice.paymentTermsMode").doesNotExist());
        matchers.add(jsonPath("$.ProductLines[0].ProductGuid").hasJsonPath());
        matchers.add(jsonPath("$.ProductLines[0].ProductGuid").isEmpty());
        matchers.add(jsonPath("$.ProductLines[0].Description").value("qwerty"));
        matchers.add(jsonPath("$.ProductLines[1].ProductGuid").isNotEmpty());
        matchers.add(jsonPath("$.ProductLines[1].Description").hasJsonPath());
        matchers.add(jsonPath("$.ProductLines[1].Description").isEmpty());
        return matchers;
    }

    @Override
    protected void doCheckEntity(Invoice entity) {
        if ("2aa6fda2-9649-483e-82ec-094567eedfd6".equals(entity.getId())) {
            assertEquals(LocalDateTime.parse("2017-05-19T14:20:47.407"), entity.getCreatedAt());
            assertEquals(InvoiceStatus.Draft, entity.getStatus());
            return;
        }

        if ("626911cd-e133-43cc-a73d-d4c6a6bc7501".equals(entity.getId())) {
            assertEquals(LocalDateTime.parse("2017-05-19T14:15:29.55"), entity.getCreatedAt());
            assertEquals(InvoiceStatus.Overdue, entity.getStatus());
            return;
        }

        throw new RuntimeException("Unexpected contact entity [id=" + entity.getId() + "]");
    }

    @Test
    public void testSendEmail() {
        System.out.println("sendEmail");
        String id = "123";
        mockServer.expect(requestTo(resource.serviceUrl + "/" + resourceName + "/" + id + "/email")).andExpect(method(HttpMethod.POST))
                .andRespond(withSuccess("{\n" +
                        "  \"Recipients\": [\n" +
                        "    {\n" +
                        "      \"Email\": \"test@previsto.com\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"Email\": \"test@previsto.com\"\n" +
                        "    }\n" +
                        "  ]\n" +
                        "}", MediaType.APPLICATION_JSON));

        InvoiceResource invoiceResource = (InvoiceResource) resource;
        SendEmailResponse response = invoiceResource.email(id);
        assertEquals("test@previsto.com", response.getRecipients().get(0).getEmail());
        mockServer.verify();
    }

}
