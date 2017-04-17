package com.previsto.billy.autoconfigure;

import javax.annotation.PostConstruct;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.util.Assert;

@ConfigurationProperties("billy")
public class BillyProperties {

    /**
     * The API key for billy.
     */
    private String apiKey;

    /**
     * The API url for billy.
     */
    private String serviceUrl;


    @PostConstruct
    protected void init() {
        Assert.notNull(this.serviceUrl, "Service url must be specified via 'billy.serviceUrl'.");
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
