package com.fergoid.health;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;

import java.util.Random;

/**
 * Created by markferguson on 27/04/2016.
 */
public class IJHealth implements HealthIndicator {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Override
    public Health health() {
        int errorCode = new Random().nextInt(); // perform some specific health check
        if (errorCode > 99999) {
            return Health.down().withDetail("Error Code", errorCode).build();
        } else {
            publishMessage(errorCode);
        }
        return Health.up().build();
    }


    private void publishMessage(int errorCode) {
        String s = "Error message was " + errorCode;
        String exchange="logs";
        String topic="com.fil.Customer.update";
        rabbitTemplate.convertAndSend(exchange, topic, s);
    }
}
