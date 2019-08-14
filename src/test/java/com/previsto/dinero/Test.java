package com.previsto.dinero;

import com.previsto.dinero.model.*;
import org.apache.commons.io.FileUtils;
import org.springframework.util.FileCopyUtils;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;

public class Test {

    public static void main(String[] args) throws IOException {

        String orgId = "148383";
        String apiKey = "33591216d5184eb39bf8f564f223b9b9";


        DineroClient client = new DineroClient("Previsto",
                "ZfnZyhqoc3B7q9GDKEAToD0W5xTbnlEwMlf3YIPQE", orgId, apiKey,
                "https://authz.dinero.dk/dineroapi/oauth/token", "https://api.dinero.dk/v1");

        Contact contact = client.getContactResource().findAll().get(0);
        Invoice invoice = new Invoice();
        invoice.setContactId(contact.getId());
        invoice.setCurrency("DKK");
        InvoiceProductLine line = new InvoiceProductLine();
        line.setBaseAmountValue(200);
        line.setDescription("Test");
        line.setAccountNumber(1000);
        line.setUnit(UnitType.Session);
        line.setQuantity(1);
        invoice.getProductLines().add(line);
        invoice = client.getInvoiceResource().save(invoice);
        System.out.println(invoice);

        /*Contact c = new Contact();
        c.setName("Blåbærgrød med Accent grú");
        c.setStreet("Blåbærvænget 123");
        c.setZipCode("9000");
        c.setCity("Ålborg");
        c = client.getContactResource().save(c);

        List<Contact> contacts = client.getContactResource().findAll();
        System.out.println(contacts.size());
*/



        /*for(Contact c : contactsCreated) {
            client.getContactResource().delete(c);
        }*/
        /*Contact contact = new Contact();
        contact.setCreditor(true);
        contact.setName("Apaq");
        contact.setStreet("Fyensgade 16, 1. th.");
        contact.setZipCode("9000");
        contact.setCity("Aalborg");
        contact.setEmail("mic@apaq.dk");
        contact = client.getContactResource().save(contact);
        
        System.out.println(contact);*/
        
        /*Product product = new Product();
        product.setName("Vinduespolering");
        product.setProductNumber("TEST_CODE");
        product.setAccountNumber(1000);
        //product.setSalesTaxRulesetId(org.getDefaultSalesTaxRulesetId());
        product = client.getProductResource().save(product);*/
        
       /* Invoice invoice = new Invoice();
        invoice.setContactId(contact.getId());
        invoice.setCurrency("DKK");
        InvoiceProductLine line = new InvoiceProductLine();
        line.setBaseAmountValue(200);
        line.setDescription("Test");
        line.setAccountNumber(1000);
        line.setUnit(UnitType.Session);
        line.setQuantity(1);
        invoice.getProductLines().add(line);
        invoice = client.getInvoiceResource().save(invoice);
        System.out.println(invoice);

        client.getInvoiceResource().book(invoice);
        client.getInvoiceResource().email(invoice.getId());

        InputStream io = client.getInvoiceResource().download(invoice.getId());
        FileCopyUtils.copy(io, new FileOutputStream("invoice.pdf"));
        io.close();

        invoice = client.getInvoiceResource().get(invoice.getId());
        client.getInvoiceResource().pay(invoice,
                55040,
                LocalDate.now(),
                1000,
                "Betaling via Previsto",
                "previsto-id");
        System.out.println(invoice);*/
        


        //client.getInvoiceResource().approve(invoice.getId());
        

        //client.getInvoiceResource().delete(invoice);
        //client.getContactResource().delete(contact);
        //client.getProductResource().delete(product);
        
    }
}
