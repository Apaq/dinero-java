package com.previsto.billy.autoconfigure;

import com.previsto.billy.autoconfigure.BillyClientFactoryAutoConfiguration;
import com.previsto.billy.autoconfigure.BillyClientAutoConfiguration;
import com.previsto.billy.BillyClient;
import com.previsto.billy.BillyClientFactory;
import org.junit.After;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

import static org.junit.Assert.*;
import org.springframework.boot.test.EnvironmentTestUtils;

public class BillyClientAutoConfigurationTest {

    private AnnotationConfigApplicationContext context;

    @After
    public void tearDown() {
        if (this.context != null) {
            this.context.close();
        }
    }

    @Test
    public void defaultNativeConnectionFactory() {
        load(EmptyConfiguration.class, 
                "billy.serviceUrl=https://api.billysbilling.com/v2", 
                "billy.apiKey=qwerty123");
        BillyClient client = this.context.getBean(BillyClient.class);
        assertEquals("qwerty123", client.getApiKey());
    }

    @Configuration
    static class EmptyConfiguration {
    }

    private void load(Class<?> config, String... environment) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        EnvironmentTestUtils.addEnvironment(applicationContext, environment);
        applicationContext.register(config);
        applicationContext.register(BillyClientAutoConfiguration.class, BillyClientFactoryAutoConfiguration.class);
        applicationContext.refresh();
        this.context = applicationContext;
    }

}
