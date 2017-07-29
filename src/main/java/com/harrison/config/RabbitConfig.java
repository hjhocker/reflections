package com.harrison.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class RabbitConfig {

    @Bean
    public Queue hello() {
        Queue q = new Queue("hello", false, false, false);
        return q;
    }

    @Profile("receiver")
    @Bean
    public RabbitConfig receiver() {
        return new RabbitConfig();
    }

    @Profile("sender")
    @Bean
    public RabbitConfig sender() {
        return new RabbitConfig();
    }
}
