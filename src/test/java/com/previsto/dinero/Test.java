package com.previsto.dinero;

import com.previsto.dinero.model.*;
import org.springframework.data.domain.Page;

import java.util.List;

import java.time.LocalDate;

public class Test {

    public static void main(String[] args) {
        
        DineroClient client = new DineroClient("Previsto",
                "ZfnZyhqoc3B7q9GDKEAToD0W5xTbnlEwMlf3YIPQE", "148383",
                "33591216d5184eb39bf8f564f223b9b9",
                "https://authz.dinero.dk/dineroapi/oauth/token", "https://api.dinero.dk/v1");
        
        List<Contact> contacts = client.getContactResource().findAll();
        System.out.println(contacts);
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
        System.out.println(invoice);*/
        

        //client.getInvoiceResource().approve(invoice.getId());
        

        //client.getInvoiceResource().delete(invoice);
        //client.getContactResource().delete(contact);
        //client.getProductResource().delete(product);
        
    }
}
