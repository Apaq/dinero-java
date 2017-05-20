package com.previsto.dinero;

import com.previsto.dinero.exception.AuthenticationException;
import com.previsto.dinero.exception.DineroException;
import com.previsto.dinero.exception.UnknownException;
import com.previsto.dinero.model.Credentials;
import com.previsto.dinero.net.RestTemplateHelper;
import com.previsto.dinero.repository.AccountResource;
import com.previsto.dinero.repository.ContactResource;
import com.previsto.dinero.repository.InvoiceResource;
import com.previsto.dinero.repository.ProductResource;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.time.LocalDate;
import java.time.Month;
import java.util.Collections;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.Header;
import org.apache.http.HttpHeaders;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public class DineroClient {

    public static final LocalDate EPOCH = LocalDate.of(1970, Month.JANUARY, 1);
    private static final Logger LOG = LoggerFactory.getLogger(DineroClient.class);
    private static final String API_KEY_HEADER = "Authorization";

    private final RestTemplate restTemplate;
    private final String authUrl;
    private final String serviceUrl;
    private String organizationId;
    private String clientId;
    private String clientSecret;
    private final String apiKey;
    private final HttpComponentsClientHttpRequestFactory requestFactory;
    private String token;
    private String fullServiceUrl;

    public DineroClient(String clientId, String clientSecret, String organizationId, String apiKey, String authUrl, String serviceUrl)  {
        this.requestFactory = new HttpComponentsClientHttpRequestFactory(HttpClients.createDefault());
        this.restTemplate = new RestTemplate(this.requestFactory);
        this.restTemplate.setErrorHandler(new ErrorHandler());
        this.serviceUrl = serviceUrl;
        this.authUrl = authUrl;
        this.apiKey = apiKey;
        this.organizationId = organizationId;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.fullServiceUrl = serviceUrl + "/" + organizationId;

        RestTemplateHelper.configureForDineroJargon(restTemplate);

        //Apply default timeouts
        this.requestFactory.setConnectTimeout(10000);
        this.requestFactory.setReadTimeout(10000);
        
        // Apply security
        String token;
        try {
            token = obtainToken();
        } catch (URISyntaxException e) {
            throw new UnknownException("Unable to obtain token. " + e.getMessage());
        }
        Header tokenHeader = new BasicHeader(API_KEY_HEADER, "Bearer " + token);
        HttpClient httpClient = HttpClients.custom().setDefaultHeaders(Collections.singleton(tokenHeader)).build();
        this.requestFactory.setHttpClient(httpClient);
    }
    
    public void setConnectTimeout(int millis) {
        this.requestFactory.setConnectTimeout(millis);
    }
    
    public void setReadTimeout(int millis) {
        this.requestFactory.setReadTimeout(millis);
    }
    
    public String getApiKey() {
        return apiKey;
    }

    public String getServiceUrl() {
        return serviceUrl;
    }

    public ContactResource getContactResource() {
        return new ContactResource(restTemplate, fullServiceUrl);
    }
    
    public InvoiceResource getInvoiceResource() {
        return new InvoiceResource(restTemplate, fullServiceUrl);
    }
    
    public ProductResource getProductResource() {
        return new ProductResource(restTemplate, fullServiceUrl);
    }
    
    public AccountResource getAccountResource() {
        return new AccountResource(restTemplate, fullServiceUrl);
    }

    private String obtainToken() throws URISyntaxException {
        if(token == null) {
            MultiValueMap<String, String> form = new LinkedMultiValueMap<String, String>();
            form.add("grant_type", "password");
            form.add("scope", "read write");
            form.add("username", apiKey);
            form.add("password", apiKey);

            RequestEntity request = RequestEntity.post(new URI(authUrl))
                    .header("Authorization", createClientToken(clientId, clientSecret))
                    .body(form);

            ResponseEntity<Credentials> result = this.restTemplate.postForEntity(authUrl, request, Credentials.class);
            token = result.getBody().getAccessToken();
        }
        return token;
    }

    private String createClientToken(String clientid, String clientSecret){
        String auth = clientid + ":" + clientSecret;
        byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("UTF-8")) );
        return "Basic " + new String( encodedAuth );
    }
}
