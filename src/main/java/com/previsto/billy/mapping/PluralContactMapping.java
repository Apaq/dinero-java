package com.previsto.billy.mapping;

import com.previsto.billy.model.Contact;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public class PluralContactMapping extends ContactMapping implements PluralMapping<Contact>{
    private List<Contact> contacts;

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    @Override
    public Page<Contact> getPage() {
        contacts.forEach(c -> resolveExtraData(c));
        return BaseMapping.resolvePage(getMeta(), contacts);
    }
    
    
}
