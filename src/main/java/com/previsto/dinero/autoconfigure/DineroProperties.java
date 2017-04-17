package com.previsto.dinero.autoconfigure;

import javax.annotation.PostConstruct;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.util.Assert;

@ConfigurationProperties("dinero")
public class DineroProperties {

    /**
     * The API key for dinero.
     */
    private String apiKey;

    /**
     * The API url for dinero.
     */
    private String serviceUrl;


    @PostConstruct
    protected void init() {
        Assert.notNull(this.serviceUrl, "Service url must be specified via 'dinero.serviceUrl'.");
    }


    public String getServiceUrl() {
        return serviceUrl;
    }

    public void setServiceUrl(String serviceUrl) {
        this.serviceUrl = serviceUrl;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }



}
