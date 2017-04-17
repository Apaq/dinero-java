package com.previsto.dinero.repository;

import com.previsto.dinero.mapping.PersistProductMapping;
import com.previsto.dinero.mapping.PluralProductMapping;
import com.previsto.dinero.mapping.SingularProductMapping;
import com.previsto.dinero.model.Product;
import java.util.HashMap;
import java.util.Map;
import org.springframework.web.client.RestTemplate;

public class ProductResource extends Resource<Product>{
    
    private static final Map<String, String> SIDELOAD_PARAMS = new HashMap<>();
    
    static {
    }
    
    public ProductResource(RestTemplate restTemplate, String serviceUrl) {
        super(SingularProductMapping.class, PluralProductMapping.class, PersistProductMapping.class, "products", restTemplate, serviceUrl, SIDELOAD_PARAMS);
    }
    
}