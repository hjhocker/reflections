package com.harrison.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("local")
public class RabbitConfig {

    @org.springframework.amqp.rabbit.annotation.EnableRabbit
    public static final class EnableRabbit {
        
    }
    
    @Bean
    public Queue hello() {
        return new Queue("hello", false, false, false);
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
