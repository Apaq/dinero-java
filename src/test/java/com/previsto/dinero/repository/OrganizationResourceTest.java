package com.previsto.dinero.repository;

import com.previsto.dinero.model.Organization;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.response.DefaultResponseCreator;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;
import static org.junit.Assert.*;
import org.springframework.test.web.client.RequestMatcher;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.*;

public class OrganizationResourceTest extends ResourceTestBase<Organization> {

    public OrganizationResourceTest() {
        super(new OrganizationResource(buildRestTemplate(), "http://server/Api"), Organization.class);
    }

    @Override
    protected DefaultResponseCreator generateExpectedGetResponse() {
        return withSuccess(Util.readResourceFromFile("organizations_single.json"), MediaType.APPLICATION_JSON);
    }

    @Override
    protected DefaultResponseCreator generateExpectedFindAllResponse() {
        return withSuccess(Util.readResourceFromFile("organizations_list.json"), MediaType.APPLICATION_JSON);
    }

    @Override
    protected String generateExpectedGetQueryParams() {
        return "";
    }

    @Override
    protected String generateSingularId() {
        return "07WgjDjARrWDUR0FAqEVEg";
    }
    
    @Override
    protected List<RequestMatcher> generateExpectedSaveRequest() {
        return Arrays.asList(new RequestMatcher[]{jsonPath("$.organization.logoUrl").doesNotExist()});
    }

    @Override
    protected void doCheckEntity(Organization entity) {
        if ("07WgjDjARrWDUR0FAqEVEg".equals(entity.getId())) {
            assertEquals(LocalDateTime.parse("2016-11-12T13:28:50"), entity.getCreatedTime());
            return;
        }

        
        throw new RuntimeException("Unexpected entity [id=" + entity.getId() + "]");
    }

}
