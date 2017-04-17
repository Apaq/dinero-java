package com.previsto.dinero.mapping;

import com.previsto.dinero.model.Contact;

public class PersistContactMapping implements PersistMapping<Contact> {
    private Contact contact;

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    @Override
    public void setEntity(Contact entity) {
        this.contact = entity;
    }
    
    
}
