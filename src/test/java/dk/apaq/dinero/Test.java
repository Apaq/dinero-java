package dk.apaq.dinero;

import dk.apaq.dinero.model.Contact;
import dk.apaq.dinero.model.Invoice;

import java.io.IOException;
import java.util.List;

public class Test {

    public static void main(String[] args) throws IOException {

        //String orgId = "107436";
        //String apiKey = "59b54638e3d5463c917e10ee68d45bff";

        String orgId = "117370";
        String apiKey = "24e85b6e163c4930aced9e60c9b5db2e";


        DineroClient client = new DineroClient("Previsto",
                "ZfnZyhqoc3B7q9GDKEAToD0W5xTbnlEwMlf3YIPQE", orgId, apiKey,
                "https://authz.dinero.dk/dineroapi/oauth/token", "https://api.dinero.dk/v1");

        //Invoice invoice = client.getInvoiceResource().get("58155e23-73b6-4178-97bf-0901ede01cde");//.get("e4f62426-3c2f-4fad-98c4-57fb4072d923");
        //Invoice invoice2 = client.getInvoiceResource().get("bd8ea633-e582-461b-b20d-47066ddb197a");//.get("e4f62426-3c2f-4fad-98c4-57fb4072d923");

        List<Contact> contacts= client.getContactResource().findAll();
        System.out.println(contacts.size());
        
    }
}
