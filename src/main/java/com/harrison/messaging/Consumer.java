package com.harrison.messaging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("local")
public class Consumer {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(Consumer.class);
    
    private int count = 1;
    
    @RabbitListener(queues = "hello")
    public void receive(String in) {
        if (in.equals("49")) {
            throw new RuntimeException("bad message");
        }
        LOGGER.info(" [x] Received '" + in + "'");
    }

}
