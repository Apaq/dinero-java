package com.previsto.billy.autoconfigure;

import com.previsto.billy.BillyClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnBean(BillyClient.class)
public class BillyHealthIndicator implements HealthIndicator {

    @Autowired
    private BillyClient client;
    
    @Override
    public Health health() {
        try {
            //client.getSubscriptionResource().findAll(new PageRequest(0, 1), false, false);
            return Health.up()
                    .withDetail("serviceUrl", client.getServiceUrl())
                    .build();
        } catch(Exception ex) {
            return Health.down(ex).build();
        }
    }

}
