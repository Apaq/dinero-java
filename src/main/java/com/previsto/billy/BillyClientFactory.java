package com.previsto.billy;

public class BillyClientFactory {

    private final String serviceUrl;

    public BillyClientFactory(String serviceUrl) {
        this.serviceUrl = serviceUrl;
    }

    public String getServiceUrl() {
        return serviceUrl;
    }
    
    public BillyClient create(String apiKey) {
        return new BillyClient(apiKey, serviceUrl);
    }
}
