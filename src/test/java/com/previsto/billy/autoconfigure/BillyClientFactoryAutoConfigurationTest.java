package com.previsto.billy.autoconfigure;

import com.previsto.billy.autoconfigure.BillyClientFactoryAutoConfiguration;
import com.previsto.billy.BillyClientFactory;
import org.junit.After;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

import static org.junit.Assert.*;
import org.springframework.boot.test.EnvironmentTestUtils;

public class BillyClientFactoryAutoConfigurationTest {

    private AnnotationConfigApplicationContext context;

    @After
    public void tearDown() {
        if (this.context != null) {
            this.context.close();
        }
    }

    @Test
    public void defaultNativeConnectionFactory() {
        load(EmptyConfiguration.class, "billy.serviceUrl=https://api.billysbilling.com/v2");
        BillyClientFactory factory = this.context.getBean(BillyClientFactory.class);
        assertEquals("https://api.billysbilling.com/v2", factory.getServiceUrl());
    }

    @Configuration
    static class EmptyConfiguration {
    }

    private void load(Class<?> config, String... environment) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        EnvironmentTestUtils.addEnvironment(applicationContext, environment);
        applicationContext.register(config);
        applicationContext.register(BillyClientFactoryAutoConfiguration.class);
        applicationContext.refresh();
        this.context = applicationContext;
    }

}
