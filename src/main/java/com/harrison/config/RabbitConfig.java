package com.harrison.config;

import org.reflections.vfs.Vfs;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class RabbitConfig {

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange("harrison.exchange", true, true);
    }

    @Bean
    public Queue helloQueue() {
        return new Queue("hello", false, false, false);
    }

    @Bean
    public Queue queue() {
        return new Queue("harrisonqueue", false, false, false);
    }

    @Bean
    public Binding binding(Queue queue, DirectExchange directExchange) {
        return BindingBuilder.bind(queue).to(directExchange).with("harrison.exchange");
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
