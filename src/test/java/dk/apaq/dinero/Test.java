package dk.apaq.dinero;

import dk.apaq.dinero.model.Contact;
import dk.apaq.dinero.model.Invoice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.io.IOException;
import java.util.List;

public class Test {

    public static void main(String[] args) throws IOException {

        String orgId = "280845";
        String apiKey = "";

        //String orgId = "148383";
        //String apiKey = "";


        DineroClient client = new DineroClient("Previsto",
                "", orgId, apiKey,
                "https://authz.dinero.dk/dineroapi/oauth/token", "https://api.dinero.dk/v1");

        Page<Invoice> invoices = client.getInvoiceResource().findAll(PageRequest.of(0, 100));
        System.out.println(invoices.getTotalElements());
        for(Invoice i : invoices) {
            System.out.println(i.getId() + " / " + i.getDate() + "/" + i.getContactName() + "/" + i.getCreatedAt() + "/" + i.getTotalInclVat());
        }
        
    }
}
