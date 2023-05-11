package com.example.com;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component("dynamicHealth")
public class DynamicHealthIndicator implements HealthIndicator {
    private static int counter = 0;

    @Override
    public Health health() {
        if (counter++ < 20) {
            return Health.up().build();
        }
        return Health.down().withDetail("err-0", "some error").build();
    }
}
