package com.previsto.billy.mapping;

import com.previsto.billy.model.Organization;

public class SingularOrganizationMapping extends OrganizationMapping implements SingularMapping<Organization> {
    private Organization organization;

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    @Override
    public Organization getEntity() {
        return organization;
    }

}
