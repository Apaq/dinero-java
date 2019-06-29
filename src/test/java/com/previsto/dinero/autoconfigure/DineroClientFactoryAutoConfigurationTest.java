package com.previsto.dinero.autoconfigure;

import com.previsto.dinero.DineroClientFactory;
import org.junit.After;
import org.junit.Test;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

import static org.junit.Assert.*;

public class DineroClientFactoryAutoConfigurationTest {

    private AnnotationConfigApplicationContext context;

    @After
    public void tearDown() {
        if (this.context != null) {
            this.context.close();
        }
    }

    @Test
    public void defaultNativeConnectionFactory() {
        load(EmptyConfiguration.class, "dinero.serviceUrl=https://api.billysbilling.com/v2");
        DineroClientFactory factory = this.context.getBean(DineroClientFactory.class);
        assertEquals("https://api.billysbilling.com/v2", factory.getServiceUrl());
    }

    @Configuration
    static class EmptyConfiguration {
    }

    private void load(Class<?> config, String... environment) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        TestPropertyValues.of(environment).applyTo(applicationContext);
        applicationContext.register(config);
        applicationContext.register(DineroClientFactoryAutoConfiguration.class);
        applicationContext.refresh();
        this.context = applicationContext;
    }

}
