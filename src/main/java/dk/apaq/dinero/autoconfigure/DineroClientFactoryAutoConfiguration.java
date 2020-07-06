package dk.apaq.dinero.autoconfigure;

import dk.apaq.dinero.DineroClientFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnMissingBean(DineroClientFactory.class)
@EnableConfigurationProperties(DineroProperties.class)
public class DineroClientFactoryAutoConfiguration {

    private static final Logger LOG = LoggerFactory.getLogger(DineroClientFactoryAutoConfiguration.class);
    
    @Autowired
    private DineroProperties properties;
    
    @Bean
    public DineroClientFactory dineroClientFactory() {
        LOG.info("Initializing DineroClientFactory. [serviceUrl={}]", properties.getServiceUrl());
        return new DineroClientFactory(properties.getClientId(), properties.getClientSecret(),
                properties.getAuthUrl(), properties.getServiceUrl());
    }
}
