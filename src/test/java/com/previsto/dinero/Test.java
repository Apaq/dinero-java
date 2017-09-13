package com.previsto.dinero;

import com.previsto.dinero.model.*;
import org.apache.commons.io.FileUtils;
import org.springframework.util.FileCopyUtils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;

public class Test {

    public static void main(String[] args) throws IOException {
        
        DineroClient client = new DineroClient("Previsto",
                "ZfnZyhqoc3B7q9GDKEAToD0W5xTbnlEwMlf3YIPQE", "148383",
                "33591216d5184eb39bf8f564f223b9b9",
                "https://authz.dinero.dk/dineroapi/oauth/token", "https://api.dinero.dk/v1");
        
        //Page<Contact> contacts = client.getContactResource().findAll(new PageRequest(0, 2));
        Contact contact = new Contact();
        contact.setCreditor(true);
        contact.setName("Apaq");
        contact.setStreet("Fyensgade 16, 1. th.");
        contact.setZipCode("9000");
        contact.setCity("Aalborg");
        contact.setEmail("mic@apaq.dk");
        contact = client.getContactResource().save(contact);
        
        System.out.println(contact);
        
        /*Product product = new Product();
        product.setName("Vinduespolering");
        product.setProductNumber("TEST_CODE");
        product.setAccountNumber(1000);
        //product.setSalesTaxRulesetId(org.getDefaultSalesTaxRulesetId());
        product = client.getProductResource().save(product);*/
        
        Invoice invoice = new Invoice();
        invoice.setContactId(contact.getId());
        invoice.setCurrency("DKK");
        InvoiceProductLine line = new InvoiceProductLine();
        line.setBaseAmountValue(200);
        line.setDescription("Test");
        line.setAccountNumber(1000);
        line.setUnit(UnitType.Session);
        line.setQuantity(1);
        //line.setDiscountValue(0);
        //line.setDiscountMode(DiscountMode.PercentageDiscount);
        //line.setProductId(product.getId());

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

        invoice = client.getInvoiceResource().get(invoice.getId());
        System.out.println(invoice);
        //client.getInvoiceResource().approve(invoice.getId());
        

        //client.getInvoiceResource().delete(invoice);
        //client.getContactResource().delete(contact);
        //client.getProductResource().delete(product);
        
    }
}
