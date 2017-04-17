package com.previsto.billy;

import com.previsto.billy.model.Contact;
import com.previsto.billy.model.Invoice;
import com.previsto.billy.model.InvoiceLine;
import com.previsto.billy.model.Organization;
import com.previsto.billy.model.Product;
import com.previsto.billy.model.enums.ContactType;

public class Test {

    public static void main(String[] args) {
        
        BillyClient client = new BillyClient("66d361eea7c89d4f9c4d56ef66b7e9bce20784e7", "https://api.billysbilling.com/v2");
        
        Organization org = client.getOrganizationResource().getCurrent();
        
        //Page<Contact> contacts = client.getContactResource().findAll(new PageRequest(0, 2));
        Contact contact = new Contact(ContactType.Company, "Apaq", "DK");
        contact.setSupplier(true);
        contact = client.getContactResource().save(contact);
        
        System.out.println(contact);
        
        Product product = new Product();
        product.setName("Vinduespolering");
        product.setProductNo("TEST_CODE");
        product.setAccountId(org.getDefaultSalesAccountId());
        //product.setSalesTaxRulesetId(org.getDefaultSalesTaxRulesetId());
        product = client.getProductResource().save(product);
        
        Invoice invoice = new Invoice();
        invoice.setContactId(contact.getId());
        invoice.setCurrencyId("DKK");
        InvoiceLine line = new InvoiceLine();
        line.setUnitPrice(200);
        line.setDescription("Test");
        //line.setDiscountValue(0);
        //line.setDiscountMode(DiscountMode.PercentageDiscount);
        line.setProductId(product.getId());
        invoice.getLines().add(line);
        invoice = client.getInvoiceResource().save(invoice);
        invoice = client.getInvoiceResource().save(invoice);
        System.out.println(invoice);
        
        //client.getInvoiceResource().approve(invoice.getId());
        
        Invoice invoice2 = new Invoice();
        invoice2.setContactId(contact.getId());
        invoice2.setCurrencyId("DKK");
        line = new InvoiceLine();
        line.setUnitPrice(200);
        line.setDescription("Test");
        //line.setDiscountValue(0);
        //line.setDiscountMode(DiscountMode.PercentageDiscount);
        line.setProductId(product.getId());
        invoice2.getLines().add(line);
        invoice2 = client.getInvoiceResource().save(invoice2);
        invoice2 = client.getInvoiceResource().save(invoice2);
        System.out.println(invoice);
        
        //client.getInvoiceResource().approve(invoice2.getId());
        
        
        client.getInvoiceResource().delete(invoice);
        client.getInvoiceResource().delete(invoice2);
        client.getContactResource().delete(contact);
        client.getProductResource().delete(product);
        
    }
}
