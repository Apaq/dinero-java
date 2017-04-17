package com.previsto.billy.autoconfigure;

import com.previsto.billy.BillyClient;
import com.previsto.billy.BillyClientFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnMissingBean(BillyClient.class)
@ConditionalOnProperty("billy.apiKey")
@EnableConfigurationProperties(BillyProperties.class)
public class BillyClientAutoConfiguration {

    private static final Logger LOG = LoggerFactory.getLogger(BillyClientAutoConfiguration.class);
    
    @Autowired
    private BillyProperties properties;
    
    @Autowired
    private BillyClientFactory clientFactory;
    
    @Bean
    public BillyClient billyClient() {
        String displayKey = properties.getApiKey() != null ? "Not NULL" : "NULL";
        LOG.info("Initializing BillyClient. [apiKey={}]", displayKey);
        return clientFactory.create(properties.getApiKey());
    }
}
