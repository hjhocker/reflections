package com.harrison.messaging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(Consumer.class);
    
    @RabbitListener(queues = "hello")
    public void receive(String in) {
        LOGGER.info(" [x] Received '" + in + "'");
    }

}
