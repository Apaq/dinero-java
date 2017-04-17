package com.previsto.dinero.mapping;

import com.previsto.dinero.model.Organization;

public class PersistOrganizationMapping implements PersistMapping<Organization> {
    private Organization organization;

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    @Override
    public void setEntity(Organization entity) {
        this.organization = entity;
    }
    
    
}
