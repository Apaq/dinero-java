package com.previsto.billy.mapping;

import com.previsto.billy.model.Organization;
import java.util.List;
import org.springframework.data.domain.Page;

public class PluralOrganizationMapping extends OrganizationMapping implements PluralMapping<Organization>{
    private List<Organization> organizations;

    public List<Organization> getOrganizations() {
        return organizations;
    }

    public void setOrganizations(List<Organization> organizations) {
        this.organizations = organizations;
    }

    @Override
    public Page<Organization> getPage() {
        organizations.forEach((i) -> resolveExtraData(i));
        return BaseMapping.resolvePage(getMeta(), organizations);
    }
    
}