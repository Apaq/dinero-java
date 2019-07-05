package com.previsto.dinero.autoconfigure;

import com.previsto.dinero.DineroClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.health.ConditionalOnEnabledHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnBean(DineroClient.class)
public class DineroHealthIndicator implements HealthIndicator {

    @Autowired
    private DineroClient client;
    
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
