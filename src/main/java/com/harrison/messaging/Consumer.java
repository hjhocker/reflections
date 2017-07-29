package com.harrison.messaging;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
    
    @RabbitListener(queues = "hello")
    public void receive(String in) {
//        String[] arr = in.split(",");
//        for (String a : arr) {
//            int i = Integer.valueOf(a);
//            char fff = (char) i;
//            System.out.println(fff);
//        }
        System.out.println(" [x] Received '" + in + "'");
    }

}
