package com.previsto.dinero.autoconfigure;

import com.previsto.dinero.DineroClient;
import org.junit.After;
import org.junit.Test;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

import static org.junit.Assert.*;

public class DineroClientAutoConfigurationTest {

    private AnnotationConfigApplicationContext context;

    @After
    public void tearDown() {
        if (this.context != null) {
            this.context.close();
        }
    }

    @Test
    public void defaultNativeConnectionFactory() {
        /*load(EmptyConfiguration.class,
                "dinero.serviceUrl=https://api.dinero.dk/v1",
                "dinero.clientId=Previsto",
                "dinero.clientSecret=ZfnZyhqoc3B7q9GDKEAToD0W5xTbnlEwMlf3YIPQE",
                "dinero.authUrl=https://authz.dinero.dk/dineroapi/oauth/token",
                "dinero.organizationId=148383");
        DineroClient client = this.context.getBean(DineroClient.class);
        assertEquals("qwerty123", client.getApiKey());*/
    }

    @Configuration
    static class EmptyConfiguration {
    }

    private void load(Class<?> config, String... environment) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        TestPropertyValues.of(environment).applyTo(applicationContext);
        applicationContext.register(config);
        applicationContext.register(DineroClientAutoConfiguration.class, DineroClientFactoryAutoConfiguration.class);
        applicationContext.refresh();
        this.context = applicationContext;
    }

}
