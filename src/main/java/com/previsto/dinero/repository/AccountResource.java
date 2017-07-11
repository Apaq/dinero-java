package com.previsto.dinero.repository;

import com.previsto.dinero.model.Account;
import java.util.HashMap;
import java.util.Map;
import org.springframework.web.client.RestTemplate;

public class AccountResource extends Resource<Account>{
    
    public AccountResource(RestTemplate restTemplate, String serviceUrl) {
        super(Account.class, "accounts", restTemplate, serviceUrl, null);
    }
    
}