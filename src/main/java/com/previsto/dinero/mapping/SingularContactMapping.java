package com.previsto.dinero.mapping;

import com.previsto.dinero.model.Contact;

public class SingularContactMapping extends ContactMapping implements SingularMapping<Contact> {
    private Contact contact;

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    @Override
    public Contact getEntity() {
        resolveExtraData(contact);
        return contact;
    }

}
