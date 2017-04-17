package com.previsto.dinero;

public class DineroClientFactory {

    private final String serviceUrl;

    public DineroClientFactory(String serviceUrl) {
        this.serviceUrl = serviceUrl;
    }

    public String getServiceUrl() {
        return serviceUrl;
    }
    
    public DineroClient create(String apiKey) {
        return new DineroClient(apiKey, serviceUrl);
    }
}
