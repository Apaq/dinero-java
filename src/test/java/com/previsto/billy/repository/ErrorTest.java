package com.previsto.billy.repository;

import com.previsto.billy.ErrorHandler;
import com.previsto.billy.exception.ApiException;
import com.previsto.billy.exception.AuthenticationException;
import com.previsto.billy.exception.RequestException;
import com.previsto.billy.exception.ResourceNotFoundException;
import com.previsto.billy.model.Contact;
import static com.previsto.billy.repository.ResourceTestBase.buildRestTemplate;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.client.RequestMatcher;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import org.springframework.test.web.client.response.DefaultResponseCreator;
import org.springframework.web.client.RestTemplate;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.*;
import static org.springframework.test.web.client.response.MockRestResponseCreators.*;

public class ErrorTest {

    private MockRestServiceServer mockServer;
    private RestTemplate restTemplate;
    
    @Before
    public void setUp() {
        restTemplate = new RestTemplate();
        restTemplate.setErrorHandler(new ErrorHandler());
        
        mockServer = MockRestServiceServer.createServer(restTemplate);
    }
    
    private DefaultResponseCreator generateBadRequestResponse() {
        return withBadRequest().body(Util.readResourceFromFile("error_bad_request.json")).contentType(MediaType.APPLICATION_JSON);
    }
    
    private DefaultResponseCreator generateUnauthorizedResponse() {
        return withUnauthorizedRequest().body(Util.readResourceFromFile("error_unauthorized.json")).contentType(MediaType.APPLICATION_JSON);
    }
    
    private DefaultResponseCreator generateNotFoundResponse() {
        return withStatus(HttpStatus.NOT_FOUND).body(Util.readResourceFromFile("error_not_found.json")).contentType(MediaType.APPLICATION_JSON);
    }
    
    private DefaultResponseCreator generateServerErrorResponse() {
        return withServerError().body(Util.readResourceFromFile("error_server_error.json")).contentType(MediaType.APPLICATION_JSON);
    }
    
    @Test
    public void testBadRequest() {
        System.out.println("get");
        
        ContactResource resource = new ContactResource(restTemplate, "http://server/Api");
        
        mockServer.expect(method(HttpMethod.GET)).andRespond(generateBadRequestResponse());
        
        try {
            Contact entity = resource.get("232132");
            mockServer.verify();
            Assert.fail("Should have thrown exception");
        } catch(RequestException ex) {
            Assert.assertTrue(ex.getMessage().contains("Invoices must have at least one invoice line"));
        }   

    }
    
    @Test
    public void testServerError() {
        System.out.println("get");
        
        ContactResource resource = new ContactResource(restTemplate, "http://server/Api");
        
        mockServer.expect(method(HttpMethod.GET)).andRespond(generateServerErrorResponse());
        
        try {
            Contact entity = resource.get("232132");
            mockServer.verify();
            Assert.fail("Should have thrown exception");
        } catch(ApiException ex) {
            
        }   

    }
    
    @Test
    public void testAuthenticationError() {
        System.out.println("get");
        
        ContactResource resource = new ContactResource(restTemplate, "http://server/Api");
        
        mockServer.expect(method(HttpMethod.GET)).andRespond(generateUnauthorizedResponse());
        
        try {
            Contact entity = resource.get("232132");
            mockServer.verify();
            Assert.fail("Should have thrown exception");
        } catch(AuthenticationException ex) {
            
        }   

    }
    
    @Test
    public void testResourceNotFoundError() {
        System.out.println("get");
        
        ContactResource resource = new ContactResource(restTemplate, "http://server/Api");
        
        mockServer.expect(method(HttpMethod.GET)).andRespond(generateNotFoundResponse());
        
        try {
            Contact entity = resource.get("232132");
            Assert.assertNull(entity);
            mockServer.verify();
        } catch(ResourceNotFoundException ex) {
            Assert.fail("Should have thrown exception");
        
        }   

    }
}
