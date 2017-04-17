package com.previsto.billy.autoconfigure;

import com.previsto.billy.BillyClientFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnMissingBean(BillyClientFactory.class)
@EnableConfigurationProperties(BillyProperties.class)
public class BillyClientFactoryAutoConfiguration {

    private static final Logger LOG = LoggerFactory.getLogger(BillyClientFactoryAutoConfiguration.class);
    
    @Autowired
    private BillyProperties properties;
    
    @Bean
    public BillyClientFactory billyClientFactory() {
        LOG.info("Initializing BilyClientFactory. [serviceUrl={}]", properties.getServiceUrl());
        return new BillyClientFactory(properties.getServiceUrl());
    }
}
