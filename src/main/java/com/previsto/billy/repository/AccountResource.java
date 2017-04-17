package com.previsto.billy.repository;

import com.previsto.billy.mapping.PersistAccountMapping;
import com.previsto.billy.mapping.PluralAccountMapping;
import com.previsto.billy.mapping.SingularAccountMapping;
import com.previsto.billy.model.Account;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.web.client.RestTemplate;

public class AccountResource extends Resource<Account>{
    
    private static final Map<String, String> SIDELOAD_PARAMS = new HashMap<>();
    
    static {
        SIDELOAD_PARAMS.put("include", "account.group");
    }

    public AccountResource(RestTemplate restTemplate, String serviceUrl) {
        super(SingularAccountMapping.class, PluralAccountMapping.class, PersistAccountMapping.class, "accounts", restTemplate, serviceUrl, SIDELOAD_PARAMS);
    }
    
}