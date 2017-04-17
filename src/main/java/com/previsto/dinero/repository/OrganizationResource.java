package com.previsto.dinero.repository;

import com.previsto.dinero.mapping.PersistOrganizationMapping;
import com.previsto.dinero.mapping.PluralOrganizationMapping;
import com.previsto.dinero.mapping.SingularMapping;
import com.previsto.dinero.mapping.SingularOrganizationMapping;
import com.previsto.dinero.model.Organization;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

public class OrganizationResource extends Resource<Organization>{
    
    private static final Map<String, String> SIDELOAD_PARAMS = new HashMap<>();
    
    static {
    //    SIDELOAD_PARAMS.put("include", "organization.lines:embed");
    }
    
    public OrganizationResource(RestTemplate restTemplate, String serviceUrl) {
        super(SingularOrganizationMapping.class, PluralOrganizationMapping.class, PersistOrganizationMapping.class, "organizations", restTemplate, serviceUrl, SIDELOAD_PARAMS);
    }
    
    public Organization getCurrent() {
        URI url;
    
        try {
            url = new URI(serviceUrl + "/organization");
        } catch (URISyntaxException ex) {
            throw new IllegalArgumentException("Url is not valid.", ex);
        }
        
        UriComponentsBuilder builder = UriComponentsBuilder.fromUri(url);
        
        for (Map.Entry<String, String> entry : sideloadParams.entrySet()) {
            builder.queryParam(entry.getKey(), entry.getValue());
        }

        url = builder.build().encode().toUri();
        SingularMapping<Organization> result = (SingularMapping<Organization>) restTemplate.getForObject(url, singularClass);
        return result == null ? null : result.getEntity();
    }
}