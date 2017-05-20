package com.previsto.dinero.autoconfigure;

import com.previsto.dinero.DineroClient;
import com.previsto.dinero.DineroClientFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnMissingBean(DineroClient.class)
@ConditionalOnProperty("dinero.apiKey")
@EnableConfigurationProperties(DineroProperties.class)
public class DineroClientAutoConfiguration {

    private static final Logger LOG = LoggerFactory.getLogger(DineroClientAutoConfiguration.class);
    
    @Autowired
    private DineroProperties properties;
    
    @Autowired
    private DineroClientFactory clientFactory;
    
    @Bean
    public DineroClient dineroClient() {
        String displayKey = properties.getApiKey() != null ? "Not NULL" : "NULL";
        LOG.info("Initializing DineroClient. [apiKey={}]", displayKey);
        return clientFactory.create(properties.getOrganizationId(), properties.getApiKey());
    }
}
